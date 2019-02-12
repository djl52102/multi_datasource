package cn.ctyun.multi_datasource.datasource;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * TODO 实际数据源配置,增加数据源需要进行配置
 * @Date: 2018/12/20 09:33
 * @author cuijianpeng
 */
@Component
@Data
@ConfigurationProperties(prefix = "hikari")
public class DBProperties {

    private HikariDataSource main;
    private HikariDataSource test;

    public HikariDataSource getMain() {
        return main;
    }

    public void setMain(HikariDataSource main) {
        this.main = main;
    }

    public HikariDataSource getTest() {
        return test;
    }

    public void setTest(HikariDataSource test) {
        this.test = test;
    }
}
