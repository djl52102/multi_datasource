package cn.ctyun.multi_datasource.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 目标数据源注解
 * @Date: 2018/12/20 09:33
 * @author cuijianpeng
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TargetDataSource {
    /**
     * 注解数据源名称
     * @return 数据源名称
     */
    String value();
}
