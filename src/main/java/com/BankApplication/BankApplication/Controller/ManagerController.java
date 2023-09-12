package com.BankApplication.BankApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BankApplication.BankApplication.Config.ResponseStructure;
import com.BankApplication.BankApplication.Dto.Manager;
import com.BankApplication.BankApplication.Service.Managerservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/manager")
public class ManagerController {
@Autowired
Managerservice mser;
@PostMapping
public ResponseEntity<ResponseStructure<Manager>> savemanager( @Valid @RequestBody Manager m,@Valid @RequestParam int bid )
{
	return mser.savemanager(m, bid);
}
@GetMapping
public ResponseEntity<ResponseStructure<Manager>> findmanager(@Valid @RequestParam int mid)
{
	return mser.findManager(mid);
}
@PostMapping("/managerlogin")
public ResponseEntity<ResponseStructure<Manager>> managerlogin( @Valid @RequestParam String mname,
		@Valid @RequestParam String mpass)
{
	return mser.loginmanager(mname, mpass);
}
}
