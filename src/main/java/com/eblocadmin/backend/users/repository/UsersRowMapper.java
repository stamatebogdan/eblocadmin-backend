package com.eblocadmin.backend.users.repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.*;
import com.eblocadmin.backend.users.entity.User;

public class UsersRowMapper implements RowMapper<User>{
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		return User.builder()
				.eba_id(rs.getLong("eba_id"))
				.firstName(rs.getString("first_name"))
				.lastName(rs.getString("last_name"))
				.telephone(rs.getString("telephone"))
				.email(rs.getString("email"))
				.contactAddress(rs.getString("contact_address"))
				.invoiceAddress(rs.getString("invoice_address"))
				.city(rs.getString("city"))
				.birthDate(getLocalDate(rs, "birth_date"))
				.insertedDate(getLocalDateTime(rs, "inserted_date"))
				.lastChangeDate(getLocalDateTime(rs, "last_change_date"))
				.build();
	}
	
	private LocalDate getLocalDate(ResultSet rs, String str) throws SQLException {
				return rs.getObject(str, LocalDate.class);
	}
	
	private LocalDateTime getLocalDateTime(ResultSet rs, String str) throws SQLException {
		return rs.getObject(str, LocalDateTime.class);
}
}
