package com.BankApplication.BankApplication.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BankApplication.BankApplication.Dto.Account;
import com.BankApplication.BankApplication.Dto.Bank;
import com.BankApplication.BankApplication.Resp.Accountres;
@Repository
public class Accountdao {

	@Autowired
	Accountres ares;

	public Account saveaccount(Account a) {
		return ares.save(a);
	}

	public Account findaccount(int aid) {
		Optional<Account> optionalaccount = ares.findById(aid);
		if (optionalaccount.isPresent()) {
			return optionalaccount.get();
		} else {
			return null;
		}
	}

	public Account updateaccount(Account upa, int id) {
		Account exist = findaccount(id);
		if (exist != null) {
			upa.setAccountid(id);
			ares.save(upa);
			return upa;
		}
		return null;
	}

	public Account deleteaccount(int aid) {
		Account exaccount = findaccount(aid);
		if (exaccount != null) {
			ares.delete(exaccount);
			return exaccount;
		} else {
			return null;
		}
	}
}
