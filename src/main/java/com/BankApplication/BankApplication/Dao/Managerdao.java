
package com.BankApplication.BankApplication.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BankApplication.BankApplication.Dto.Manager;
import com.BankApplication.BankApplication.Resp.Managerres;

@Repository
public class Managerdao {
	@Autowired
	Managerres mrespo;

	public Manager savemanager(Manager m) {
		return mrespo.save(m);
	}

	public Manager findmanager(int id) {
		Optional<Manager> optionalmanager = mrespo.findById(id);
		if (optionalmanager.isPresent()) {
			return optionalmanager.get();
		}
		return null;
	}

	public Manager deletemanager(int id) {
		Manager existmanager = findmanager(id);
		if (existmanager != null) {
			mrespo.delete(existmanager);
			return existmanager;
		}
		return null;
	}

	public Manager updatemanager(Manager upm, int id) {
		Manager exist = findmanager(id);
		if (exist != null) {
			upm.setManagerid(id);
			mrespo.save(upm);
			return upm;
		}
		return null;
	}

	public Manager login(String mname, String mpass) {
		return mrespo.login(mname, mpass);

	}
	public Manager getname(String name)
	{
		return mrespo.getname(name); 
	}
}
