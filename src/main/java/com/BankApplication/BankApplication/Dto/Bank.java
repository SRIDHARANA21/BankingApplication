package com.BankApplication.BankApplication.Dto;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
@Component
@Entity
@Getter
@Setter
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bankid;
	@NotBlank(message = "bankname Not accept space")
	@NotNull(message = "bankname Not accept null")
	private String bankname;
	@Pattern(regexp  = "^[A-Z]{4}0[A-Z0-9]{6}$",message = "Invalid IFSC code" )
	private String bankifsc;
	@NotBlank(message = " banklocation Not accept space")
	@NotNull(message = "banklocation Not accept null")
	private String banklocation;
	@OneToOne(cascade = CascadeType.ALL)
	private Manager manager;
	@OneToMany(cascade = CascadeType.ALL)
	private List<User> userlist;

}
