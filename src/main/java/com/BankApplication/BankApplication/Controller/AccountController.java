package com.BankApplication.BankApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BankApplication.BankApplication.Config.ResponseStructure;
import com.BankApplication.BankApplication.Dto.Account;
import com.BankApplication.BankApplication.Service.Accountservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountController {
@Autowired
Accountservice aser;

@PostMapping
public ResponseEntity<ResponseStructure<Account>> saveaccount(@Valid @RequestParam int userid,@Valid @RequestParam String mname,@Valid @RequestParam String mpass,
		@Valid @RequestParam	int accounttype, @Valid @ RequestBody Account newaccount)
{
	return  aser.saveaccount(userid, mname, mpass, accounttype, newaccount);
}
@GetMapping
public ResponseEntity<ResponseStructure<Account>> findaccount(@Valid @RequestParam int  aid)
{
	return  aser.findaccount(aid);
}
@GetMapping("/deleteacc")
public ResponseEntity<ResponseStructure<Account>> deleteaccount(@Valid @RequestParam int accid, @Valid @RequestParam String mname,
		@Valid @RequestParam String mpass,@Valid @RequestParam int bid)
{
	 return  aser.deleteaccount(accid, mname, mpass, bid);
}
}
