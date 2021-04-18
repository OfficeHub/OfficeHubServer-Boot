package com.officehub.officehubserver.OfficeHubServer;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@MapperScan(basePackageClasses = OfficeHubServerApplication.class)
@SpringBootApplication
public class OfficeHubServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfficeHubServerApplication.class, args);
	}

}
