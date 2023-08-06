package com.eblocadmin.backend.units.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.eblocadmin.backend.units.entity.UnitLink;

public class UnitLinkRowMapper implements RowMapper<UnitLink>{
	
	public UnitLink mapRow(ResultSet rs, int rowNum) throws SQLException {
		return UnitLink.builder()
				.ebaId(rs.getLong("eba_id"))
				.ebaPrimaryUnitId(rs.getInt("eba_primary_unit_id"))
				.ebaPrimaryUnitName(rs.getString("eba_primary_unit_name"))
				.ebaSecondaryUnitId(rs.getInt("eba_secondary_unit_id"))
				.ebaSecondaryUnitName(rs.getString("eba_secondary_unit_name"))
				.insertedDate(getLocalDateTime(rs, "inserted_date"))
				.lastChangeDate(getLocalDateTime(rs, "last_change_date"))
				.build();
	}
	
	private LocalDate getLocalDate (ResultSet rs, String str) throws SQLException {
		return rs.getObject(str, LocalDate.class);
	}
	
	private LocalDateTime getLocalDateTime (ResultSet rs, String str) throws SQLException {
		return rs.getObject(str, LocalDateTime.class);
	}

}
