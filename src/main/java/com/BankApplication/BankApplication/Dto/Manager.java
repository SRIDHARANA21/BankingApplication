package com.BankApplication.BankApplication.Dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
@Component
@Setter
@Getter
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int managerid;
	@NotBlank(message = "This section is not accepting space or balnk")
	@NotNull(message = "This section is not accepting null")
	private String managername;
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "invalid email")
	private String managerEmail;
	@ Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$”",message = "password must contain one number,one albhabetic,one uppercase,one special character" )
	private String  managerpass;
	@Positive
	@Min(value = 6000000000l)
	@Max(value = 9000000000l)
	private long managercontact;
	@OneToOne(cascade = CascadeType.ALL)
	private Bank managerbank;

}
