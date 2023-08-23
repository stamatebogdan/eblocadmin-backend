package com.eblocadmin.backend.units.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.eblocadmin.backend.users.entity.TypeOfRent;
import com.eblocadmin.backend.users.entity.UserType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnitLink {
	
	@Id
	private Long ebaId;
	
	private Integer ebaPrimaryUnitId;
	private String ebaPrimaryUnitName;
	private Integer ebaSecondaryUnitId;
	private String ebaSecondaryUnitName;
	private LocalDateTime insertedDate;
	private LocalDateTime lastChangeDate;

}
