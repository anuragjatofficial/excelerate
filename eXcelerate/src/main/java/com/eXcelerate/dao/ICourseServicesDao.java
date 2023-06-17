package com.eXcelerate.dao;

import java.util.List;
import java.util.Set;

import com.eXcelerate.entities.Assignment;
import com.eXcelerate.entities.Course;
import com.eXcelerate.exceptions.NoAccountLoggedInException;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public interface ICourseServicesDao {
	Set<Course> showCourses() throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException;

	List<Assignment> showAssignments()throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException;
}
