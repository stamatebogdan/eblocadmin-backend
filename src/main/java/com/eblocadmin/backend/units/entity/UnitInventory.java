package com.eblocadmin.backend.units.entity;

import java.time.LocalDateTime;

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
public class UnitInventory {
	
	@Id
	private Long ebaId;
	
	private Integer unitId;
	private String  unitName;
	private Boolean airConditioner;
	private Boolean smokeDetector;
	private Boolean gasOven;
	private Boolean electricOven;
	private Boolean microwaveOven;
	private Boolean electricStove;
	private Boolean thermalPlant;
	private Boolean waterMeter;
	private Boolean wifi;
	private Boolean refrigerator;
	private Boolean vacuumCleaner;
	private Boolean mop;
	private Boolean couch;
	private Boolean bed;
	private Boolean mattress;
	private LocalDateTime insertedDate;
	private LocalDateTime lastChangeDate;

}
