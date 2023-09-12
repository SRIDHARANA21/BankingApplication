package com.BankApplication.BankApplication.Exception;

public class UserPasswordNotFound extends RuntimeException {
	private String message = " Wrong User password  ";

	public String getgmessage() {
		return message;
	}

	public void  UserPasswordNotFound(String message)
	{
		this.message=message;
	}
}
