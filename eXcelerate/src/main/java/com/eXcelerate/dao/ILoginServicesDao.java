package com.eXcelerate.dao;

import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public interface ILoginServicesDao {
	Boolean LoginInstructor(String username,String password) throws NoSuchRecordFoundException, SomethingWentWrongException;

	Boolean LoginStudent(String username, String password)throws NoSuchRecordFoundException, SomethingWentWrongException;;
}
