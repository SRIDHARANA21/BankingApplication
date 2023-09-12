package com.BankApplication.BankApplication.Resp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BankApplication.BankApplication.Dto.Transaction;

public interface Transcationres extends JpaRepository<Transaction, Integer> {
	

}
