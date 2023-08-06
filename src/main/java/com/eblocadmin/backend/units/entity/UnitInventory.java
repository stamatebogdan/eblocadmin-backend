package com.eblocadmin.backend.units.entity;

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
public class UnitInventory {
	
	private Long ebaId;
	private Integer unitId;
	private Unit unitName;
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
