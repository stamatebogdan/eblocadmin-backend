package com.eblocadmin.backend.dbconnection.config;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class PostgresDataSourceConfig {
	
	@Value(value="${app.postgres.url}")
	private String postgresUrl;
	
	@Value(value="${app.postgres.username}")
	private String postgresUser;
	
	@Value(value="${app.postgres.password}")
	private String postgresPassword;	
	
	
	public HikariDataSource getHikariDataSource() {
		
		HikariConfig jdbcConfig = new HikariConfig();
		jdbcConfig.setJdbcUrl(postgresUrl);
		jdbcConfig.setUsername(postgresUser);
		jdbcConfig.setPassword(postgresPassword);
		jdbcConfig.setSchema("users_group");
		jdbcConfig.addDataSourceProperty( "cachePrepStmts" , "true" );
		jdbcConfig.addDataSourceProperty( "prepStmtCacheSize" , "250" );
		jdbcConfig.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
		
		return new HikariDataSource(jdbcConfig);		
	}
	
	
}
