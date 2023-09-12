package com.BankApplication.BankApplication.Exception;

public class ManagerNotFound extends RuntimeException {
	private String message="Manager not found";
	public String getmessage()
	{
		return message;
	}
	public void  ManagerNotFound(String message)
	{
		this.message=message;
	}

}
