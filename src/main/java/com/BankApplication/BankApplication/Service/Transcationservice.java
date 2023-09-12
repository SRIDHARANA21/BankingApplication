package com.BankApplication.BankApplication.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.BankApplication.BankApplication.Config.ResponseStructure;
import com.BankApplication.BankApplication.Dao.Accountdao;
import com.BankApplication.BankApplication.Dao.Transcationdao;
import com.BankApplication.BankApplication.Dao.Userdao;
import com.BankApplication.BankApplication.Dto.Account;
import com.BankApplication.BankApplication.Dto.Manager;
import com.BankApplication.BankApplication.Dto.Transaction;
import com.BankApplication.BankApplication.Dto.TranscationType;
import com.BankApplication.BankApplication.Dto.User;
import com.BankApplication.BankApplication.Exception.AccountNotFound;
import com.BankApplication.BankApplication.Exception.TranscationTypeNotFound;
import com.BankApplication.BankApplication.Exception.UserNameNotFound;
import com.BankApplication.BankApplication.Exception.UserNotFound;
import com.BankApplication.BankApplication.Exception.UserPasswordNotFound;
import com.BankApplication.BankApplication.Resp.Transcationres;

@Service
public class Transcationservice {
	@Autowired
	Transcationres tres;
	@Autowired
	Userdao udao;
	@Autowired
	Transcationdao tdao;
	@Autowired
	Accountdao adao;

	public ResponseEntity<ResponseStructure<Transaction>> createtranscation(String uname, String upass, int transamt,
			int transcationtype) {
		User exuser = udao.login(uname, upass);
		if (exuser != null) {
			Account exacc = exuser.getUseraccount();
			if (exacc != null) {
				if (transcationtype == 1) {
					Transaction t = new Transaction();
					t.setStatus(TranscationType.CREADITED);
					t.setTransactionamount(transamt);
					t.setTransactiondate(LocalDate.now());
					tdao.savetranscation(t);
					List<Transaction> extrans = exacc.getListtrans();
					extrans.add(t);
					exacc.setListtrans(extrans);
					exacc.setAccountbalance(exacc.getAccountbalance() + transamt);
					adao.updateaccount(exacc, exacc.getAccountid());
					ResponseStructure<Transaction> structure = new ResponseStructure<>();
					structure.setData(t);
					structure.setMessage("Transcation successfull,created");
					structure.setStaus(HttpStatus.CREATED.value());
					exuser.setUseraccount(exacc);
					udao.updateuser(exuser, exuser.getUserid());
					return new ResponseEntity<ResponseStructure<Transaction>>(structure, HttpStatus.CREATED);
				} else if (transcationtype == 2) {
					if (exacc.getAccountbalance() >= transamt) {
						Transaction t = new Transaction();
						t.setStatus(TranscationType.DEBITED);
						t.setTransactionamount(transamt);
						t.setTransactiondate(LocalDate.now());
						tdao.savetranscation(t);
						List<Transaction> extrans = exacc.getListtrans();
						extrans.add(t);
						exacc.setListtrans(extrans);
						exacc.setAccountbalance(exacc.getAccountbalance() - transamt);
						adao.updateaccount(exacc, exacc.getAccountid());
						ResponseStructure<Transaction> structure = new ResponseStructure<>();
						structure.setData(t);
						structure.setMessage("Transcation success,debited");
						structure.setStaus(HttpStatus.CREATED.value());
						exuser.setUseraccount(exacc);
						udao.updateuser(exuser, exuser.getUserid());
						return new ResponseEntity<ResponseStructure<Transaction>>(structure, HttpStatus.CREATED);
					}
					throw new TranscationTypeNotFound();
				}
			}
			throw new AccountNotFound();

		}
		throw new UserNotFound();
	}

	public ResponseEntity<ResponseStructure<List<Transaction>>> findalltranscation(String name, String password) {
		ResponseStructure<List<Transaction>> structure = new ResponseStructure<>();
		User checkuser = udao.getname(name);
		if (checkuser != null) {
			if (checkuser.getUserpassword().equals(password)) {
				structure.setMessage("User loged successfully ");
				structure.setStaus(HttpStatus.ACCEPTED.value());
				structure.setData(tdao.findalltranscation());
				return new ResponseEntity<ResponseStructure<List<Transaction>>>(structure, HttpStatus.ACCEPTED);
			}
			throw new UserPasswordNotFound();
		}
		throw new UserNameNotFound();

	}
}
