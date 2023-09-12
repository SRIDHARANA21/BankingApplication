package com.BankApplication.BankApplication.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.BankApplication.BankApplication.Config.ResponseStructure;

public class AccountNotFound  extends RuntimeException{
 String message="Account not found";
 public String getmessage()
 {
	 return message;
 }
public void AccountNotFound(String message)
 {
 	this.message=message;
 }
 
}
