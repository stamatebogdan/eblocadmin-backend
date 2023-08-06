package com.eblocadmin.backend.units.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnitInfo {
	
	private Long ebaId;
	private Integer unitId;
	private Unit unitName;
	private Unit unitPurchasePrice;
	private Boolean unitWarranty;
	private LocalDate unitWarrantyDueDate;
	private String unitNotes;
	private Byte unitPhoto1;
	private Byte unitPhoto2;
	private Byte unitPhoto3;
	private Byte unitPhoto4;
	private Byte unitPhoto5;
	private Byte unitPhoto6;
	private Byte unitPhoto7;
	private Byte unitPhoto8;
	private Byte unitPhoto9;
	private Byte unitPhoto10;
	private Byte unitDocument1;
	private Byte unitDocument2;
	private Byte unitDocument3;
	private Byte unitDocument4;
	private Byte unitDocument5;
	private Byte unitDocument6;
	private Byte unitDocument7;
	private Byte unitDocument8;
	private Byte unitDocument9;
	private Byte unitDocument10;
	private LocalDateTime insertedDate;
	private LocalDateTime lastChangeDate;
	
}
