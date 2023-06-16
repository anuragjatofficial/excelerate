package com.eXcelerate.dao;

import com.eXcelerate.entities.Course;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public interface IAdminServicesDao {

	void addCourses(Course course)throws SomethingWentWrongException;

}
