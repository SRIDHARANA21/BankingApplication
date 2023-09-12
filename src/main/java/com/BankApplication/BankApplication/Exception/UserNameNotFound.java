package com.BankApplication.BankApplication.Exception;

public class UserNameNotFound extends RuntimeException {
private String message="user not found";
public String getmessage()
{
	return message;
}
public void UserNameNotFound(String message)
{
	this.message=message;
}
}
