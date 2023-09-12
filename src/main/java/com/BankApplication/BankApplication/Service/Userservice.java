package com.BankApplication.BankApplication.Service;

import java.sql.Struct;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import com.BankApplication.BankApplication.Exception.UserNameNotFound;
import com.BankApplication.BankApplication.Exception.UserNotFound;
import com.BankApplication.BankApplication.Exception.UserPasswordNotFound;

@Service
public class Userservice {
	@Autowired
	Userdao udao;
	@Autowired
	Managerdao mdao;
	@Autowired
	Bankdao bdao;

	public ResponseEntity<ResponseStructure<User>> saveuser(User newuser, int bankid) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		Bank existbank = bdao.findbank(bankid);
		if (existbank != null) {
			structure.setMessage("user Saved successfully");
			structure.setStaus(HttpStatus.CREATED.value());
			List<User> userlist = existbank.getUserlist();
			userlist.add(newuser);
			existbank.setUserlist(userlist);
			structure.setData(udao.saveuser(newuser));
			bdao.updatebank(existbank, existbank.getBankid());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
		}
		throw new BankNotFound();
	}

	public ResponseEntity<ResponseStructure<User>> finduser(int id) {
		User finduser = udao.finduser(id);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (finduser != null) {
			structure.setMessage("user founded");
			structure.setStaus(HttpStatus.FOUND.value());
			structure.setData(finduser);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);

		}
		throw new UserNotFound();
	}

	public ResponseEntity<ResponseStructure<User>> deleteuser(int id, int bid) {
		User exuser = udao.deleteuser(id);
		Bank exbank = bdao.findbank(bid);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (exuser != null) {
			if (exbank != null) {
				List<User> userlist = exbank.getUserlist();
				userlist.remove(exuser);
				structure.setMessage("user deleted successfully");
				structure.setStaus(HttpStatus.OK.value());
				structure.setData(udao.deleteuser(exuser.getUserid()));
				bdao.updatebank(exbank, exbank.getBankid());
				return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);

			}
			throw new BankNotFound();
		}
		throw new UserNotFound();

	}

	public ResponseEntity<ResponseStructure<User>> updateuser(User updateuser, int id) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		User upuser = udao.finduser(id);
		if (upuser != null) {
			structure.setMessage("user founded");
			structure.setStaus(HttpStatus.OK.value());
			structure.setData(udao.updateuser(updateuser, id));

			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);

		}
		throw new UserNotFound();
	}

	public ResponseEntity<ResponseStructure<User>> loginUser(String name, String pass) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		User username = udao.getname(name);
		if (username != null) {
			if (username.getUserpassword().equals(pass)) {
				structure.setMessage("user loged successfully");
				structure.setStaus(HttpStatus.ACCEPTED.value());
				structure.setData(username);
				return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
			}
			throw new UserPasswordNotFound();
		}
		throw new UserNameNotFound();
	}
}
