package com.eblocadmin.backend.units.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.eblocadmin.backend.units.entity.Unit;
import com.eblocadmin.backend.units.entity.UnitInventory;

public class UnitInventoryRowMapper implements RowMapper<UnitInventory>{
	
	public UnitInventory mapRow(ResultSet rs, int rowNum) throws SQLException {
		return UnitInventory.builder()
				.ebaId(rs.getLong("eba_id"))
				.unitId(rs.getInt("unit_id"))
				.unitName(rs.getString("unit_name"))
				.airConditioner(rs.getBoolean("air_conditioner"))
				.smokeDetector(rs.getBoolean("smoke_detector"))
				.gasOven(rs.getBoolean("gas_oven"))
				.electricOven(rs.getBoolean("electric_oven"))
				.microwaveOven(rs.getBoolean("microwave_oven"))
				.electricStove(rs.getBoolean("electric_stove"))
				.thermalPlant(rs.getBoolean("thermal_plant"))
				.waterMeter(rs.getBoolean("water_meter"))
				.wifi(rs.getBoolean("wifi"))
				.refrigerator(rs.getBoolean("refrigerator"))
				.vacuumCleaner(rs.getBoolean("vacuum_cleaner"))
				.mop(rs.getBoolean("mop"))
				.couch(rs.getBoolean("couch"))
				.bed(rs.getBoolean("bed"))
				.mattress(rs.getBoolean("mattress"))
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
