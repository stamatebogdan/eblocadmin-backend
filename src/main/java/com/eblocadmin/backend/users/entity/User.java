package com.eblocadmin.backend.users.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
	private long eba_id;
	
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String address;
	private String phone;
	private LocalDate birthDate;
	private LocalDateTime insertedDate;
	private LocalDateTime lastChangeDate;
	
	public String toString() {
		return String.format("Users[eba_id=%s, firstName=%s, lastName=%s, userName=%s, address=%s, birthDate=%s, insertedDate=%s, lastChangeDate=%s]", eba_id, firstName, lastName, userName, address,birthDate, insertedDate, lastChangeDate);
	}
}
