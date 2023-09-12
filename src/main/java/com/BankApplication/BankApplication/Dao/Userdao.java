package com.BankApplication.BankApplication.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BankApplication.BankApplication.Dto.User;
import com.BankApplication.BankApplication.Resp.Userrespo;

@Repository
public class Userdao {
	@Autowired
	Userrespo respo;

	public User saveuser(User u) {
		return respo.save(u);
	}

	public User finduser(int id) {
		Optional<User> optionaluser = respo.findById(id);
		if (optionaluser.isPresent()) {
			return optionaluser.get();
		}
		return null;
	}

	public User deleteuser(int id) {
		User existuser = finduser(id);
		if (existuser != null) {
			respo.delete(existuser);
			return existuser;
		}
		return null;
	}

	public User updateuser(User up, int id) {
		User exit = finduser(id);
		if (exit != null) {
			up.setUserid(id);
			if (up.getUsername() == null) {
				up.setUsername(exit.getUsername());
			}
			if (up.getUsercontact() == 0) {
				up.setUsercontact(exit.getUsercontact());
			}
			if (up.getUseraddress() == null) {
				up.setUseraddress(exit.getUseraddress());
			}
			if (up.getUserpassword() == null) {
				up.setUserpassword(exit.getUserpassword());
			}
			if (up.getUseraccount() == null) {
				up.setUseraccount(exit.getUseraccount());
			}
            respo.save(up);
			return up;
		}

		return null;
	}

	public List<User> displayalluser() {
		return respo.findAll();
	}

	public User login(String name, String pass) {
		return respo.loginuser(name, pass);
	}

	public User getname(String name) {
		return respo.logname(name);
	}
}
