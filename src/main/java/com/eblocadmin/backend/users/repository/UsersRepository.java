package com.eblocadmin.backend.users.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		String select = "SELECT * FROM users_group.eba_user_profile";

		usersList = postgresNamedParameterJdbcTemplate.query(select, new UsersRowMapper());

		return usersList;

	}

	public void insertUser(User user) {
		String insertQuery = "INSERT INTO users_group.eba_user_profile("
				+ "	first_name, last_name, telephone, email, contact_address, invoice_address, city, birth_date, inserted_date, last_change_date)"
				+ "	VALUES (:firstName, :lastName, :telephone, :email, :contactAddress, :invoiceAddress, :city, :birthDate, :insertedDate, :lastChangeDate)";

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("firstName", user.getFirstName());
		parameter.addValue("lastName", user.getLastName());
		parameter.addValue("telephone", user.getTelephone());
		parameter.addValue("email", user.getEmail());
		parameter.addValue("contactAddress", user.getContactAddress());
		parameter.addValue("invoiceAddress", user.getInvoiceAddress());
		parameter.addValue("city", user.getCity());
		parameter.addValue("birthDate", user.getBirthDate());
		parameter.addValue("insertedDate", LocalDateTime.now());
		parameter.addValue("lastChangeDate", LocalDateTime.now());

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());
		postgresNamedParameterJdbcTemplate.update(insertQuery, parameter);
	}
}
