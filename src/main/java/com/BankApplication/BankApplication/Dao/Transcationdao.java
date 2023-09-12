package com.BankApplication.BankApplication.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BankApplication.BankApplication.Dto.Transaction;
import com.BankApplication.BankApplication.Resp.Transcationres;
@Repository
public class Transcationdao {
@Autowired
Transcationres tres;

public Transaction savetranscation(Transaction t)
{
	return tres.save(t);
}
public List<Transaction> findalltranscation()
{	
	List<Transaction> transcations=tres.findAll();
	if(!transcations.isEmpty())
	{
		return transcations;
	}
	return null;
	 
	
}


}
