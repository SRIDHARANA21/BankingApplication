package com.BankApplication.BankApplication.Resp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankApplication.BankApplication.Dto.Account;

public interface Accountres extends JpaRepository<Account,Integer > {

}
