package com.BankApplication.BankApplication.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.BankApplication.BankApplication.Config.ResponseStructure;
import com.BankApplication.BankApplication.Dao.Accountdao;
import com.BankApplication.BankApplication.Dao.Bankdao;
import com.BankApplication.BankApplication.Dao.Managerdao;
import com.BankApplication.BankApplication.Dao.Userdao;
import com.BankApplication.BankApplication.Dto.Account;
import com.BankApplication.BankApplication.Dto.AccountType;
import com.BankApplication.BankApplication.Dto.Bank;
import com.BankApplication.BankApplication.Dto.Manager;
import com.BankApplication.BankApplication.Dto.User;
import com.BankApplication.BankApplication.Exception.AccountNotFound;
import com.BankApplication.BankApplication.Exception.ManagerNameNotFound;
import com.BankApplication.BankApplication.Exception.ManagerNotFound;
import com.BankApplication.BankApplication.Exception.ManagerPasswordNotFound;
import com.BankApplication.BankApplication.Exception.UserNotFound;

@Service
public class Accountservice {
	@Autowired
	Accountdao adao;
	@Autowired
	Managerdao mdao;
	@Autowired
	Userdao udao;
	@Autowired
	Bankdao bdao;

	public ResponseEntity<ResponseStructure<Account>> saveaccount(int userid, String mname, String mpass,
			int accounttype, Account newaccount) {
		ResponseStructure<Account> structure = new ResponseStructure<>();
		Manager existman = mdao.getname(mname);
		User existus = udao.finduser(userid);
		if (existman != null) {
			if (existman.getManagerpass().equals(mpass)) {
				if (existus != null) {
					structure.setMessage("manager permission granted");
					structure.setStaus(HttpStatus.CREATED.value());
					if (accounttype == 1) {
						newaccount.setAcctype(AccountType.SAVINGS);
					} else if (accounttype == 2) {
						newaccount.setAcctype(AccountType.CURRENT);
					} else if (accounttype == 1) {
						newaccount.setAcctype(AccountType.SAVINGS);
					}
					if (accounttype == 3) {
						newaccount.setAcctype(AccountType.LOAN);
					}
					throw new UserNotFound();
				}
				newaccount.setAccountuser(existus);
				existus.setUseraccount(newaccount);
				structure.setData(newaccount);
				udao.updateuser(existus, existus.getUserid());
				return new ResponseEntity<ResponseStructure<Account>>(structure, HttpStatus.CREATED);
			}
			throw new ManagerNameNotFound();
		}
		throw new ManagerPasswordNotFound();
	}

	public ResponseEntity<ResponseStructure<Account>> findaccount(int aid) {
		ResponseStructure<Account> structure = new ResponseStructure<>();
		Account existacc = adao.findaccount(aid);
		if (existacc != null) {
			structure.setMessage("Account is founded");
			structure.setStaus(HttpStatus.FOUND.value());
			structure.setData(adao.findaccount(aid));
			return new ResponseEntity<ResponseStructure<Account>>(structure, HttpStatus.FOUND);

		}
		throw new AccountNotFound();
	}

	public ResponseEntity<ResponseStructure<Account>> deleteaccount(int accid, String mname, String mpass, int bid) {
		Manager exmanager = mdao.login(mname, mpass);
		if (exmanager != null) {
			Account acc = adao.findaccount(accid);
			if (acc != null) {
				User exus = acc.getAccountuser();
				Bank exban = bdao.findbank(bid);
				List<User> exusers = exban.getUserlist();
				exusers.remove(exus);
				exban.setUserlist(exusers);
				bdao.updatebank(exban, bid);
				ResponseStructure<Account> structure = new ResponseStructure<>();
				structure.setData(adao.deleteaccount(bid));
				structure.setMessage("Account deleted successfully!!");
				structure.setStaus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Account>>(structure, HttpStatus.OK);

			}
			throw new AccountNotFound();
		}
		throw new ManagerPasswordNotFound();

	}

}
