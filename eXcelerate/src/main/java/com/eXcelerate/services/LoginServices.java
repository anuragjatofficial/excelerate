package com.eXcelerate.services;

import com.eXcelerate.dao.ILoginServicesDao;
import com.eXcelerate.dao.LoginServicesDao;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public class LoginServices implements ILoginServices {

	@Override
	public Boolean LoginStudent(String username, String password)
			throws SomethingWentWrongException, NoSuchRecordFoundException {
		ILoginServicesDao iLd = new LoginServicesDao();
		return iLd.LoginStudent(username, password);
	}

	@Override
	public Boolean LoginInstructor(String username, String password)
			throws SomethingWentWrongException, NoSuchRecordFoundException {
		ILoginServicesDao iLd = new LoginServicesDao();
		return iLd.LoginInstructor(username, password);
	}

	@Override
	public Boolean LoginAdmin(String username, String password) {
		if (username.equals("admin") && password.equals("admin"))
			return true;
		return false;
	}

}
