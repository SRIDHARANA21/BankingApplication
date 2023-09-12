package com.BankApplication.BankApplication.Config;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseStructure<T> {
private int staus; 
private String message;
private T data;
}
