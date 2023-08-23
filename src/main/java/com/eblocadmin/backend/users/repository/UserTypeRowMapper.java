package com.eblocadmin.backend.users.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.eblocadmin.backend.users.entity.TypeOfRent;
import com.eblocadmin.backend.users.entity.User;
import com.eblocadmin.backend.users.entity.UserType;

public class UserTypeRowMapper implements RowMapper<UserType>{
	public UserType mapRow(ResultSet rs, int rowNum) throws SQLException {
		return UserType.builder()
				.ebaId(rs.getLong("eba_id"))
				.firstName(rs.getString("first_name"))
				.lastName(rs.getString("last_name"))
				.landlord(rs.getBoolean("landlord"))
				.tenant(rs.getBoolean("tenant"))
				.moveInDate(getLocalDate(rs, "move_in_date"))
				.moveOutDate(getLocalDate(rs, "move_out_date"))
				.loadedDocuments(rs.getByte("loaded_documents"))
				.idDocuments(rs.getByte("id_documents"))
				.payedWarranty(rs.getInt("payed_warranty"))
				.dayOfPayment(rs.getInt("day_of_payment"))
				.typeOfRent(getTypeOfRent(rs, "type_of_rent"))
				.insertedDate(getLocalDateTime(rs, "inserted_date"))
				.lastChangeDate(getLocalDateTime(rs, "last_change_date"))
				.build();
	}
	
	private TypeOfRent getTypeOfRent (ResultSet rs, String str) throws SQLException {
		return rs.getObject(str, TypeOfRent.class);
	}
	
	private LocalDate getLocalDate(ResultSet rs, String str) throws SQLException {
				return rs.getObject(str, LocalDate.class);
	}
	
	private LocalDateTime getLocalDateTime(ResultSet rs, String str) throws SQLException {
		return rs.getObject(str, LocalDateTime.class);
	}

}
