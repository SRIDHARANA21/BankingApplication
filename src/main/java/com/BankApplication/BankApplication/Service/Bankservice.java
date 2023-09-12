package com.BankApplication.BankApplication.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.BankApplication.BankApplication.Config.ResponseStructure;
import com.BankApplication.BankApplication.Dao.Bankdao;
import com.BankApplication.BankApplication.Dao.Managerdao;
import com.BankApplication.BankApplication.Dao.Userdao;
import com.BankApplication.BankApplication.Dto.Bank;
import com.BankApplication.BankApplication.Dto.Manager;
import com.BankApplication.BankApplication.Dto.User;
import com.BankApplication.BankApplication.Exception.BankNotFound;
import com.BankApplication.BankApplication.Exception.ManagerNameNotFound;
import com.BankApplication.BankApplication.Exception.ManagerPasswordNotFound;
import com.BankApplication.BankApplication.Resp.Bankrespo;

@Service
public class Bankservice {
	@Autowired
	Bankdao bdao;
	@Autowired
	Managerdao mdao;
	@Autowired
	Userdao udao;

	public ResponseEntity<ResponseStructure<Bank>> savebank(Bank b) {
		ResponseStructure<Bank> structure = new ResponseStructure<>();

		structure.setMessage("Bank addes successfully");
		structure.setStaus(HttpStatus.CREATED.value());
		structure.setData(bdao.savebank(b));
		return new ResponseEntity<ResponseStructure<Bank>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Bank>> findbank(int bid) {
		ResponseStructure<Bank> structure = new ResponseStructure<>();
		Bank exbank = bdao.findbank(bid);
		if (exbank != null) {
			structure.setMessage("Bank is found");
			structure.setStaus(HttpStatus.FOUND.value());
			structure.setData(bdao.findbank(bid));
			return new ResponseEntity<ResponseStructure<Bank>>(structure, HttpStatus.FOUND);
		}
		throw new BankNotFound();
	}

//	public ResponseEntity<ResponseStructure<Bank>> deletebank(int bid) {
//		ResponseStructure<Bank> structure = new ResponseStructure<>();
//
//		structure.setMessage("Bank id is founded");
//		structure.setStaus(HttpStatus.OK.value());
//		structure.setData(bdao.deletebank(bid));
//		return new ResponseEntity<ResponseStructure<Bank>>(structure, HttpStatus.OK);
//
//	}
//
//	public ResponseEntity<ResponseStructure<Bank>> updatebank(Bank upb, int id) {
//		ResponseStructure<Bank> structure = new ResponseStructure<>();
//		structure.setMessage("Bank updated successfully");
//		structure.setStaus(HttpStatus.OK.value());
//		structure.setData(bdao.updatebank(upb, id));
//		return new ResponseEntity<ResponseStructure<Bank>>(structure, HttpStatus.OK);
//	}

	public ResponseEntity<ResponseStructure<List<User>>> findalluser(String name, String password) {
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		Manager checkmanager = mdao.getname(name);
		if (checkmanager != null) {
			if (checkmanager.getManagerpass().equals(password)) {
				structure.setMessage("Permission Granted");
				structure.setStaus(HttpStatus.ACCEPTED.value());
				structure.setData(udao.displayalluser());
				return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.ACCEPTED);
			}
			throw new ManagerPasswordNotFound();
		}
		throw new ManagerNameNotFound();

	}
}
