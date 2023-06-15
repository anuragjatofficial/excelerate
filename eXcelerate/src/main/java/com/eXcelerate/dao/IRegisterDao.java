package com.eXcelerate.dao;

import com.eXcelerate.entities.Instructor;
import com.eXcelerate.entities.Student;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public interface IRegisterDao {
	String registerInstructor(Instructor instructor) throws SomethingWentWrongException;
	String registerStudent(Student student)throws SomethingWentWrongException;
}
