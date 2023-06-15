package com.eXcelerate.services;

import com.eXcelerate.dao.IRegisterDao;
import com.eXcelerate.dao.RegisterDao;
import com.eXcelerate.entities.Instructor;
import com.eXcelerate.entities.Student;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public class RegisterServices implements IRegisterServices{

	@Override
	public String registerStudent(Student student) throws SomethingWentWrongException {
		IRegisterDao iRd = new RegisterDao();
		return iRd.registerStudent(student);
	}

	@Override
	public String registerInstructor(Instructor instructor) throws SomethingWentWrongException {
		IRegisterDao iRd = new RegisterDao();
		return iRd.registerInstructor(instructor);
	}

}
