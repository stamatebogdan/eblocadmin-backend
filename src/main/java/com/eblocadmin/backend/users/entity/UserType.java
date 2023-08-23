package com.eblocadmin.backend.users.entity;

import java.time.LocalDate;
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
public class UserType {
	
	@Id
	private Long ebaId;
	
	private String firstName;
	private String lastName;
	private Boolean landlord;
	private Boolean tenant;
	private LocalDate moveInDate;
	private LocalDate moveOutDate;
	private Byte loadedDocuments;
	private Byte idDocuments;
	private Integer payedWarranty;
	private Integer dayOfPayment;
	private TypeOfRent typeOfRent;
	private LocalDateTime insertedDate;
	private LocalDateTime lastChangeDate;
	private Integer ebaUserProfileId;
}
