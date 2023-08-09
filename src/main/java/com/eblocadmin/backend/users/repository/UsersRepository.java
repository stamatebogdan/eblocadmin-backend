package com.eblocadmin.backend.users.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eblocadmin.backend.dbconnection.config.PostgresDataSourceConfig;
import com.eblocadmin.backend.units.entity.Unit;
import com.eblocadmin.backend.units.repository.UnitRowMapper;
import com.eblocadmin.backend.users.entity.User;
import com.eblocadmin.backend.users.entity.UserType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UsersRepository {

	private final PostgresDataSourceConfig postgresDataSourceConfig;

	public UsersRepository(PostgresDataSourceConfig postgresDataSourceConfig) {
		this.postgresDataSourceConfig = postgresDataSourceConfig;
	}

	// Retrieve all data from eba_user_profile table
	public List<User> retrieveAllUsers() {

		List<User> usersList = new ArrayList<>();

		String select = "SELECT * FROM users_group.eba_user_profile";

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		usersList = postgresNamedParameterJdbcTemplate.query(select, new UserRowMapper());

		return usersList;

	}

	// Retrieve specific data from eba_user_profile table
	public List<User> retrieveSpecificUserByEbaId(User user) {

		List<User> userList = new ArrayList<>();

		String searchQuery = "SELECT * FROM users_group.eba_user_profile WHERE eba_id = :ebaId";

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("ebaId", user.getEbaId());

		userList = postgresNamedParameterJdbcTemplate.query(searchQuery, parameter, new UserRowMapper());

		return userList;
	}

	// Insert all users in eba_user_profile table
	public void insertUser(User user) {
		String insertQuery = "INSERT INTO users_group.eba_user_profile( first_name, last_name, telephone, email, "
				+ "contact_address, invoice_address, city, birth_date, inserted_date, last_change_date) "
				+ "VALUES (:firstName, :lastName, :telephone, :email, :contactAddress, :invoiceAddress, "
				+ ":city, :birthDate, :insertedDate, :lastChangeDate)";

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("firstName", user.getFirstName());
		parameters.addValue("lastName", user.getLastName());
		parameters.addValue("telephone", user.getTelephone());
		parameters.addValue("email", user.getEmail());
		parameters.addValue("contactAddress", user.getContactAddress());
		parameters.addValue("invoiceAddress", user.getInvoiceAddress());
		parameters.addValue("city", user.getCity());
		parameters.addValue("birthDate", user.getBirthDate());
		parameters.addValue("insertedDate", LocalDateTime.now());
		parameters.addValue("lastChangeDate", LocalDateTime.now());

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());
		postgresNamedParameterJdbcTemplate.update(insertQuery, parameters);
	}

	// Delete a user row from eba_user_profile
	public void deleteSpecificUserByEbaId(User user) {

		String deleteQuery = "DELETE FROM users_group.eba_user_profile WHERE eba_id = :ebaId;";

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("ebaId", user.getEbaId());

		postgresNamedParameterJdbcTemplate.update(deleteQuery, parameter);
	}

	// Retrieve all data from eba_user_type table
	public List<UserType> retrieveAllUserTypes() {

		List<UserType> userTypeList = new ArrayList<>();

		String select = "SELECT * FROM users_group.eba_user_type";

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		userTypeList = postgresNamedParameterJdbcTemplate.query(select, new UserTypeRowMapper());

		return userTypeList;
	}

	// Retrieve specific data from eba_user_type table
	public List<UserType> retrieveSpecificUserTypeByEbaId(UserType userType) {

		List<UserType> userTypeList = new ArrayList<>();

		String searchQuery = "SELECT * FROM users_group.eba_user_type WHERE eba_id = :ebaId";

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("ebaId", userType.getEbaId());

		userTypeList = postgresNamedParameterJdbcTemplate.query(searchQuery, parameter, new UserTypeRowMapper());

		return userTypeList;
	}

	// Insert all user type in eba_user_profile table
	public void insertUserType(UserType userType) {
		String insertQuery = "INSERT INTO users_group.eba_user_type(first_name, last_name, landlord, tenant, "
				+ "move_in_date, move_out_date, loaded_documents, id_documents, payed_warranty, day_of_payment, "
				+ "type_of_rent, inserted_date, last_change_date, eba_user_profile_id) "
				+ "VALUES (:first_name, :last_name, :landlord, :tenant, :move_in_date, :move_out_date, "
				+ ":loaded_documents, :id_documents, :payed_warranty, :day_of_payment, :type_of_rent, "
				+ ":inserted_date, :last_change_date, :eba_user_profile_id)";

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("first_name", userType.getFirstName());
		parameters.addValue("last_name", userType.getLastName());
		parameters.addValue("landlord", userType.getLandlord());
		parameters.addValue("tenant", userType.getTenant());
		parameters.addValue("move_in_date", userType.getMoveInDate());
		parameters.addValue("move_out_date", userType.getMoveOutDate());
		parameters.addValue("loaded_documents", userType.getLoadedDocuments());
		parameters.addValue("id_documents", userType.getIdDocuments());
		parameters.addValue("payed_warranty", userType.getPayedWarranty());
		parameters.addValue("day_of_payment", userType.getDayOfPayment());
		parameters.addValue("type_of_rent", userType.getTypeOfRent());
		parameters.addValue("inserted_date", LocalDateTime.now());
		parameters.addValue("last_change_date", LocalDateTime.now());
		parameters.addValue("eba_user_profile_id", userType.getEbaUserProfileId());

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());
		postgresNamedParameterJdbcTemplate.update(insertQuery, parameters);

	}

	// Delete a userType row from eba_user_type
	public void deleteSpecificUserTypeByEbaId(UserType userType) {

		String deleteQuery = "DELETE FROM users_group.eba_user_type WHERE eba_id = :ebaId;";

		NamedParameterJdbcTemplate postgresNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				postgresDataSourceConfig.getHikariDataSource());

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("ebaId", userType.getEbaId());

		postgresNamedParameterJdbcTemplate.update(deleteQuery, parameter);
	}
}
