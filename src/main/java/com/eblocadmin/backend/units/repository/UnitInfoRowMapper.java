package com.eblocadmin.backend.units.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.eblocadmin.backend.units.entity.Unit;
import com.eblocadmin.backend.units.entity.UnitInfo;

public class UnitInfoRowMapper implements RowMapper<UnitInfo>{
	
	public UnitInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		return UnitInfo.builder()
				.ebaId(rs.getLong("eba_id"))
				.unitId(rs.getInt("unit_id"))
				.unitName(getUnitObject(rs, "unit_name"))
				.unitPurchasePrice(getUnitObject(rs, "unit_purchase_price"))
				.unitWarranty(rs.getBoolean("unit_warranty"))
				.unitWarrantyDueDate(getLocalDate(rs, "unit_warranty_due_date"))
				.unitNotes(rs.getString("unit_notes"))
				.unitPhoto1(rs.getByte("unit_photo_1"))
				.unitPhoto2(rs.getByte("unit_photo_2"))
				.unitPhoto3(rs.getByte("unit_photo_3"))
				.unitPhoto4(rs.getByte("unit_photo_4"))
				.unitPhoto5(rs.getByte("unit_photo_5"))
				.unitPhoto6(rs.getByte("unit_photo_6"))
				.unitPhoto7(rs.getByte("unit_photo_7"))
				.unitPhoto8(rs.getByte("unit_photo_8"))
				.unitPhoto9(rs.getByte("unit_photo_9"))
				.unitPhoto10(rs.getByte("unit_photo_10"))
				.unitDocument1(rs.getByte("unit_document_1"))
				.unitDocument2(rs.getByte("unit_document_2"))
				.unitDocument3(rs.getByte("unit_document_3"))
				.unitDocument4(rs.getByte("unit_document_4"))
				.unitDocument5(rs.getByte("unit_document_5"))
				.unitDocument6(rs.getByte("unit_document_6"))
				.unitDocument7(rs.getByte("unit_document_7"))
				.unitDocument8(rs.getByte("unit_document_8"))
				.unitDocument9(rs.getByte("unit_document_9"))
				.unitDocument10(rs.getByte("unit_document_10"))
				.insertedDate(getLocalDateTime(rs, "inserted_date"))
				.lastChangeDate(getLocalDateTime(rs, "last_change_date"))
				.build();
	}
	
	private Unit getUnitObject ( ResultSet rs, String str) throws SQLException {
		return rs.getObject(str, Unit.class);
	}
	
	private LocalDate getLocalDate (ResultSet rs, String str) throws SQLException {
		return rs.getObject(str, LocalDate.class);
	}
	
	private LocalDateTime getLocalDateTime (ResultSet rs, String str) throws SQLException {
		return rs.getObject(str, LocalDateTime.class);
	}

}
