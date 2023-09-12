package com.BankApplication.BankApplication.Resp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BankApplication.BankApplication.Dto.Manager;

public interface Managerres extends JpaRepository<Manager, Integer> {

	@Query("select m from Manager m where m.managername=?1")
	public Manager getname(String name);

	@Query("select m from Manager m where m.managername=?1 and m.managerpass=?2")
	public Manager login(String mname, String mpass);
}
