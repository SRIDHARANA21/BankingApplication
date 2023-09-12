package com.BankApplication.BankApplication.Resp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BankApplication.BankApplication.Dto.Bank;
import com.BankApplication.BankApplication.Dto.User;

public interface Bankrespo extends JpaRepository<Bank, Integer> {

}
