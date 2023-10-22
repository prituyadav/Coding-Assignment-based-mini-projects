package com.user.Entities;

import java.time.LocalDate;

import org.hibernate.validator.constraints.UniqueElements;

import com.user.Enums.UserType;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	
	@NotEmpty
	@Size(min = 3, message = "Costomer Name should contain 3 or more than 3 latters !!")
	private String name;
	
	private LocalDate dateOfBirth;         // format--  yyyy-mm-dd
	
	
	
	@NotEmpty
	@Email
	private String email;
	
	
	
	@NotEmpty
	@Size(min = 10, max = 10, message = "mobile No.  must be exact 10 digit !!")
	@Digits(fraction = 0, integer = 10, message = "mobile No. should contains the number only !!")
	private String mobileNo;

	
	@NotNull
	@Enumerated
	private UserType userType;
	
}
