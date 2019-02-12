package cn.ctyun.multi_datasource.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO 数据源配置,增加数据源需要进行配置
 * @Date: 2018/12/20 09:33
 * @author cuijianpeng
 */
@Configuration
@EnableScheduling
public class DataSourceConfig {

    @Autowired
    private DBProperties properties;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        //按照目标数据源名称和目标数据源对象的映射存放在Map中
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("main", properties.getMain());
        targetDataSources.put("test", properties.getTest());
        //采用是想AbstractRoutingDataSource的对象包装多数据源
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);
        //设置默认的数据源，无指定数据源时，使用此配置
        dataSource.setDefaultTargetDataSource(properties.getMain());
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
