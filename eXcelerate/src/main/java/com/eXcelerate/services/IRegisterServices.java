package com.eXcelerate.services;

import com.eXcelerate.entities.Instructor;
import com.eXcelerate.entities.Student;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public interface IRegisterServices {
	String registerStudent(Student student) throws SomethingWentWrongException;
	String registerInstructor(Instructor instructor) throws SomethingWentWrongException;
}
