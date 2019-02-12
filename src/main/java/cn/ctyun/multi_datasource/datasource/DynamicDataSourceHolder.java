package cn.ctyun.multi_datasource.datasource;

/**
 * 动态数据源持有者，负责利用ThreadLocal存取数据源名称
 * @Date: 2018/12/20 09:33
 * @author cuijianpeng
 */
public class DynamicDataSourceHolder {
    /**
     * 本地线程共享数据源
     */
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void putDataSource(String name) {
        THREAD_LOCAL.set(name);
    }

    public static String getDataSource() {
        return THREAD_LOCAL.get();
    }

    public static void removeDataSource() {
        THREAD_LOCAL.remove();
    }
}
