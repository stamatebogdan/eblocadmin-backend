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
public class User {

	@Id
	private Long ebaId;

	private String firstName;
	private String lastName;
	private String telephone;
	private String email;
	private String contactAddress;
	private String invoiceAddress;
	private String city;
	private LocalDate birthDate;
	private LocalDateTime insertedDate;
	private LocalDateTime lastChangeDate;

//	public String toString() {
//		return String.format(
//				"Users[eba_id=%s, firstName=%s, lastName=%s, telephone=%s, email=%s, contact_address=%s, invoice_address=%s, city=%s, birthDate=%s, insertedDate=%s, lastChangeDate=%s]",
//				eba_id, firstName, lastName, telephone, email, contactAddress, invoiceAddress, city, birthDate,
//				insertedDate, lastChangeDate);
//	}
}
