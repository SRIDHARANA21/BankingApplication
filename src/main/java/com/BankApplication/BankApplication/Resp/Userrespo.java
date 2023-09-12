package com.BankApplication.BankApplication.Resp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BankApplication.BankApplication.Dto.User;

public interface Userrespo extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.username=?1 and u.userpassword=?2")
	public User loginuser(String name, String pass);

	@Query("select u from User u where u.username=?1")
	public User logname(String name);

}
