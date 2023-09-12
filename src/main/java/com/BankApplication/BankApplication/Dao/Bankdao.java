package com.BankApplication.BankApplication.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BankApplication.BankApplication.Dto.Bank;
import com.BankApplication.BankApplication.Dto.User;
import com.BankApplication.BankApplication.Resp.Bankrespo;

@Repository
public class Bankdao {
	@Autowired
	Bankrespo bankres;

	public Bank savebank(Bank m) {
		return bankres.save(m);
	}

	public Bank findbank(int id) {
		Optional<Bank> optionalbank = bankres.findById(id);
		if (optionalbank.isPresent()) {
			return optionalbank.get();
		}
		return null;
	}

	public Bank deletebank(int id) {
		Bank existbank = findbank(id);
		if (existbank != null) {
			bankres.delete(existbank);
			return existbank;
		}
		return null;
	}

	public Bank updatebank(Bank upb, int id) {
		Bank exist = findbank(id);
		if (exist != null) {
			upb.setBankid(id);
			bankres.save(upb);
			return upb;
		}
		return null;
	}

}
