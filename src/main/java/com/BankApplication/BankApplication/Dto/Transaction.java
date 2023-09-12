package com.BankApplication.BankApplication.Dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Component
@Setter
@Getter
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionid;
	private double  transactionamount;
	private int userid;
	private TranscationType status;
	private LocalDate transactiondate;
}
