package com.BankApplication.BankApplication.Exception;

public class UserNotFound extends RuntimeException {
private String message="user not found";
public String getmessage()
{
	return message;
}
public void  UserNotFound(String message)
{
	this.message=message;
}
}
