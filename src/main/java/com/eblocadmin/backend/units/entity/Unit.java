package com.eblocadmin.backend.units.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Unit {
	
	@Id
	private Long ebaId;
	private String unitName;
	private String unitType;
	private Integer ownerId;
	private Integer tenantId;
	private String unitStreet;
	private String unitStreetNumber;
	private String unitBlock;
	private String unitEntrance;
	private String unitFloor;
	private String unitApartNumber;
	private String unitPostalCode;
	private String unitRegion;
	private String unitCity;
	private String unitCountry;
	private Integer unitRoom;
	private Integer unitBathrooms;
	private Integer unitUsefulArea;
	private Integer unitConstructedArea;
	private Integer unitLandArea;
	private LocalDate unitConstructionDate;
	private Integer unitPurchasePrice;
	private Integer unitMarketValue;
	private Boolean unitParkingSpot;
	private String unitAdditionalNote;
	private String unitUsefulLinks;
	private LocalDateTime insertedDate;
	private LocalDateTime lastChangeDate;
}
