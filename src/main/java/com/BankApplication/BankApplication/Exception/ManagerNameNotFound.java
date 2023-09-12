package com.BankApplication.BankApplication.Exception;

public class ManagerNameNotFound extends RuntimeException {
private String message="Manager not Found";
public String getmessage() {
	return message;
}
public void ManagerNameNotFound(String message)
{
	this.message=message;
}
}
