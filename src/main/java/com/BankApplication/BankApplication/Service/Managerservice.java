package com.BankApplication.BankApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.BankApplication.BankApplication.Config.ResponseStructure;
import com.BankApplication.BankApplication.Dao.Bankdao;
import com.BankApplication.BankApplication.Dao.Managerdao;
import com.BankApplication.BankApplication.Dto.Bank;
import com.BankApplication.BankApplication.Dto.Manager;
import com.BankApplication.BankApplication.Dto.User;
import com.BankApplication.BankApplication.Exception.BankNotFound;
import com.BankApplication.BankApplication.Exception.ManagerNameNotFound;
import com.BankApplication.BankApplication.Exception.ManagerNotFound;
import com.BankApplication.BankApplication.Exception.ManagerPasswordNotFound;
import com.BankApplication.BankApplication.Resp.Managerres;

@Service
public class Managerservice {
	@Autowired
	Managerdao mdao;
	@Autowired
	Managerres mres;
	@Autowired
	Bankdao bdao;

	public ResponseEntity<ResponseStructure<Manager>> savemanager(Manager m, int bid) {
		ResponseStructure<Manager> structure = new ResponseStructure<>();
		Bank existbank = bdao.findbank(bid);
		if (existbank != null) {
			structure.setMessage("manager added successfully");
			structure.setStaus(HttpStatus.CREATED.value());
			structure.setData(mdao.savemanager(m));
			return new ResponseEntity<ResponseStructure<Manager>>(structure, HttpStatus.CREATED);

		}
		throw new BankNotFound();
	}

	public ResponseEntity<ResponseStructure<Manager>> findManager(int id) {
		ResponseStructure<Manager> structure = new ResponseStructure<>();
		Manager exmanager = mdao.findmanager(id);
		if (exmanager != null) {
			structure.setMessage("Manager found");
			structure.setStaus(HttpStatus.FOUND.value());
			structure.setData(mdao.findmanager(id));
			return new ResponseEntity<ResponseStructure<Manager>>(structure, HttpStatus.FOUND);
		}
		throw new ManagerNotFound();
	}

	public ResponseEntity<ResponseStructure<Manager>> loginmanager(String name, String password) {
		ResponseStructure<Manager> structure = new ResponseStructure<>();
		Manager manager = mdao.getname(name);
		if (manager != null) {
			if (manager.getManagerpass().equals(password)) {
				structure.setMessage("manager logged successfully!!!");
				structure.setStaus(HttpStatus.ACCEPTED.value());
				structure.setData(manager);
				return new ResponseEntity<ResponseStructure<Manager>>(structure, HttpStatus.ACCEPTED);

			}
			throw new ManagerPasswordNotFound();
		}
		throw new ManagerNameNotFound();
	}

}
