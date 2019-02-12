package cn.ctyun.multi_datasource.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源实现类
 * @Date: 2018/12/20 09:33
 * @author cuijianpeng
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * //从共享线程中获取数据源名称
     * @return 数据源名称
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDataSource();
    }
}
