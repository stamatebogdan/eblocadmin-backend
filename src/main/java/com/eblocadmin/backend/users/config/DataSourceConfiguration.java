package com.eblocadmin.backend.users.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfiguration {
	
	@Value("${spring.datasource.url}")
	private String postgresUrl;
	
	@Value("${spring.datasource.username}")
	private String postgresUsername;
	
	@Value("${spring.datasource.password}")
	private String postgresPass;
	
	@Bean
	@Primary
	public HikariDataSource hikariDataSource(){		
		return DataSourceBuilder
				.create()
				.type(HikariDataSource.class)
				.url(postgresUrl)
				.username(postgresUsername)
				.password(postgresPass)
				.build();		
	}
}
