package com.BankApplication.BankApplication.Exception;

public class TranscationTypeNotFound extends RuntimeException {
	private String message = "Transcation not found ";

	public String getmessage() {
		return message;
	}

	public void TranscationTypeNotFound(String message) {
		this.message = message;
	}
}
