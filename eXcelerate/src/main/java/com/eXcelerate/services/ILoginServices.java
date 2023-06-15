package com.eXcelerate.services;

import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public interface ILoginServices {
	Boolean  LoginStudent(String username,String password) throws SomethingWentWrongException, NoSuchRecordFoundException;
	Boolean LoginInstructor(String username,String password) throws SomethingWentWrongException, NoSuchRecordFoundException;
	Boolean LoginAdmin(String username, String password);
}
