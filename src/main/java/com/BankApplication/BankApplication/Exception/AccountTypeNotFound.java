package com.BankApplication.BankApplication.Exception;

public class AccountTypeNotFound extends RuntimeException {
	private String message="Account not found ";
	public String getmessage()
	{
		return message;
	}
	public void AccountTypeNotFound(String message)
	{
		this.message=message;
	}
}
