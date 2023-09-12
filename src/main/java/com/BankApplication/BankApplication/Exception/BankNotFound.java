package com.BankApplication.BankApplication.Exception;

public class BankNotFound extends RuntimeException {
  String message="Bank not Found";
  public String message()
  {
	  return message;
  }
  public void BankNotFound(String message)
  {
	  this.message=message;
  }
}
