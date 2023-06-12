package com.eblocadmin.backend.users.repository;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eblocadmin.backend.dbconnection.config.PostgresDataSourceConfig;
import com.eblocadmin.backend.users.entity.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UsersRepository {
	
	private final PostgresDataSourceConfig postgresDataSourceConfig;
	
	public UsersRepository(PostgresDataSourceConfig postgresDataSourceConfig) {
		this.postgresDataSourceConfig = postgresDataSourceConfig;
	}
	
	public List<User> getAnything() {
		
		List<User> usersList = new ArrayList<>();
		
		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(postgresDataSourceConfig.getHikariDataSource());
		
		String select = "SELECT * FROM users_group.eba_user_profile";
		
		usersList =  postgresNamedParameterJdbcTemplate.query(select, new UsersRowMapper());
		
		return usersList;

	}
	
	public void insertUser(User user) {
		 String insertQuery = "INSERT INTO users_group.eba_user_profile("
		 		+ "	first_name, last_name, username, email, address, phone, birth_date, inserted_date, last_change_date)"
		 		+ "	VALUES (:firstName, :lastName, :username, :email, :address, :phone, :birthDate, :insertedDate, :lastChangeDate)";
		 		 
		 MapSqlParameterSource parameter = new MapSqlParameterSource();
		 parameter.addValue("firstName", user.getFirstName());
		 parameter.addValue("lastName", user.getLastName());
		 parameter.addValue("username", user.getUserName());
		 parameter.addValue("email", user.getEmail());
		 parameter.addValue("address", user.getAddress());
		 parameter.addValue("phone", user.getPhone());
		 parameter.addValue("birthDate", user.getBirthDate());
		 parameter.addValue("insertedDate", LocalDateTime.now());
		 parameter.addValue("lastChangeDate", LocalDateTime.now());
		 
		 NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(postgresDataSourceConfig.getHikariDataSource());
		 postgresNamedParameterJdbcTemplate.update(insertQuery, parameter);		 
	}
}
