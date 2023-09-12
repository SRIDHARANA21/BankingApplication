package com.BankApplication.BankApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BankApplication.BankApplication.Config.ResponseStructure;
import com.BankApplication.BankApplication.Dao.Userdao;
import com.BankApplication.BankApplication.Dto.Transaction;
import com.BankApplication.BankApplication.Dto.User;
import com.BankApplication.BankApplication.Resp.Transcationres;
import com.BankApplication.BankApplication.Service.Transcationservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transcation")
public class TranscationController {
	@Autowired
	Transcationservice tser;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Transaction>> createtranscation(@Valid @RequestParam String uname,
			@Valid @RequestParam String upass, @Valid @RequestParam int transamt,@Valid  @RequestParam int transcationtype) {
		return tser.createtranscation(uname, upass, transamt, transcationtype);

	}
	@GetMapping("/findalltranscation")
	public ResponseEntity<ResponseStructure<List<Transaction>>>findalltranscation(@Valid @RequestParam String uname,
			@Valid @RequestParam String upassword)
	{
		return tser.findalltranscation(uname, upassword);
	}
	
}
