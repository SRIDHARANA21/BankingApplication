package com.BankApplication.BankApplication.Exception;

public class ManagerPasswordNotFound  extends RuntimeException{
 private String message="Wrong Manager password";
 public String getmessage()
 {
	 return message;
 }
 public void ManagerPasswordNotFound(String message)
 {
	 this.message=message;
 }
}
