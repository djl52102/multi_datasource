package cn.ctyun.multi_datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("cn.ctyun.multi_datasource.dao")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MultiDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiDatasourceApplication.class, args);
	}

}

