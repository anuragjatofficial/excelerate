package com.eXcelerate.services;

import com.eXcelerate.entities.Course;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public interface IAdminServices {
	void addCourses(Course course) throws SomethingWentWrongException;
}
