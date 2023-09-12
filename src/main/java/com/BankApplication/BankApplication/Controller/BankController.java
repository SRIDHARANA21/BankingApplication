package com.BankApplication.BankApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BankApplication.BankApplication.Config.ResponseStructure;
import com.BankApplication.BankApplication.Dto.Bank;
import com.BankApplication.BankApplication.Dto.User;
import com.BankApplication.BankApplication.Service.Bankservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bank")
public class BankController {
	@Autowired
	Bankservice bser;

	@PostMapping
	public ResponseEntity<ResponseStructure<Bank>> savebank(@Valid @RequestBody Bank b) {
		return bser.savebank(b);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Bank>> findbank(@Valid @RequestParam int bid) {
		return bser.findbank(bid);
	}

	@GetMapping("/findalluser")
	public ResponseEntity<ResponseStructure<List<User>>> findalluser(@Valid @RequestParam String name,
			@Valid	@RequestParam String password) {
    return bser.findalluser(name, password);
	}
}
