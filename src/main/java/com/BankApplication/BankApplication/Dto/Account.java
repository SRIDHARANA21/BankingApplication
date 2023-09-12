package com.BankApplication.BankApplication.Dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Component
@Entity
@Getter
@Setter

public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountid;
	@Positive
	@Pattern(regexp = "^[0-9]+$",message = "Account number invalid")
	private long accountnumber;
	private AccountType acctype;
	private double accountbalance;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private User accountuser;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Transaction> listtrans;

}
