package cn.ctyun.multi_datasource.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 数据源AOP切面定义
 * @Date: 2018/12/20 09:33
 * @author cuijianpeng
 */
@Component
@Aspect
public class DataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);
    /**
     * mapper切点
     */
    @Pointcut("execution( * cn.ctyun.*.dao.*.*(..))")
    public void dataSourcePointCut() {
    }

    @Before("dataSourcePointCut()")
    public void before(JoinPoint joinPoint) {
        Object target = joinPoint.getTarget();
        String method = joinPoint.getSignature().getName();
        Class<?>[] clazz = target.getClass().getInterfaces();
        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
        try {
            Method m = clazz[0].getMethod(method, parameterTypes);
            //如果方法上存在切换数据源的注解，则根据注解内容进行数据源切换
            if (m != null && m.isAnnotationPresent(TargetDataSource.class)) {
                TargetDataSource data = m.getAnnotation(TargetDataSource.class);
                String dataSourceName = data.value();
                DynamicDataSourceHolder.putDataSource(dataSourceName);
                logger.debug("current thread " + Thread.currentThread().getName() + " add " + dataSourceName + " to ThreadLocal");
            }
        } catch (Exception e) {
            logger.error("current thread " + Thread.currentThread().getName() + " add data to ThreadLocal error", e);
        }
    }

    /**
     * 将线程共享中的数据源名称清空
     * @param joinPoint joinPoint
     */
    @After("dataSourcePointCut()")
    public void after(JoinPoint joinPoint){
        DynamicDataSourceHolder.removeDataSource();
    }
}
