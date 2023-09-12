package com.BankApplication.BankApplication.Dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	@NotBlank(message = "This section is not accept the sapce or balnk this is mandatory")
	@NotNull(message = "This section is not accept null values")
	
	private String username;
	@Positive
	@Min(value = 6000000000l)
	@Max(value = 9000000000l)
	private long usercontact;
	private String useraddress;
	@ Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$”",message = "password must contain one number,one albhabetic,one uppercase,one special character" )
	private String userpassword;
	@OneToOne(cascade = CascadeType.ALL)
	private Account useraccount;
	
	

}
