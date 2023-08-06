package com.eblocadmin.backend.units.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.jdbc.core.RowMapper;

import com.eblocadmin.backend.units.entity.TypeOfUnit;
import com.eblocadmin.backend.units.entity.Unit;

public class UnitRowMapper implements RowMapper<Unit>{
	
	public Unit mapRow(ResultSet rs, int rowNum) throws SQLException {
		return Unit.builder()
				.ebaId(rs.getLong("eba_id"))
				.unitName(rs.getString("unit_name"))
				.unitType(getTypeOfUnit(rs,"unit_type"))
				.ownerId(rs.getInt("eba_owner_id"))
				.tenantId(rs.getInt("eba_tenant_id"))
				.unitStreet(rs.getString("unit_street"))
				.unitStreetNumber(rs.getString("unit_street_number"))
				.unitBlock(rs.getString("unit_block"))
				.unitEntrance(rs.getString("unit_entrance"))
				.unitFloor(rs.getString("unit_floor"))
				.unitApartNumber(rs.getString("unit_apart_number"))
				.unitPostalCode(rs.getString("unit_postal_code"))
				.unitRegion(rs.getString("unit_region"))
				.unitCity(rs.getString("unit_city"))
				.unitCountry(rs.getString("unit_country"))
				.unitRoom(rs.getInt("unit_rooms"))
				.unitBathrooms(rs.getInt("unit_bathrooms"))
				.unitUsefulArea(rs.getInt("unit_useful_area"))
				.unitConstructedArea(rs.getInt("unit_constructed_area"))
				.unitLandArea(rs.getInt("unit_land_area"))
				.unitConstructionDate(getLocalDate(rs,"unit_construction_date"))
				.unitPurchasePrice(rs.getInt("unit_purchase_price"))
				.unitMarketValue(rs.getInt("unit_market_value"))
				.unitParkingSpot(rs.getBoolean("unit_parking_spot"))
				.unitAdditionalNote(rs.getString("unit_additional_note"))
				.insertedDate(getLocalDateTime(rs, "inserted_date"))
				.lastChangeDate(getLocalDateTime(rs, "last_change_date"))
				.build();
		
	}
	
	private TypeOfUnit getTypeOfUnit (ResultSet rs, String str) throws SQLException {
		return rs.getObject(str, TypeOfUnit.class);
	}
	
	private LocalDate getLocalDate (ResultSet rs, String str) throws SQLException {
		return rs.getObject(str, LocalDate.class);
	}
	
	private LocalDateTime getLocalDateTime (ResultSet rs, String str) throws SQLException {
		return rs.getObject(str, LocalDateTime.class);
	}
	
}
