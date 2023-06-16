package com.eXcelerate.dao;

import java.util.List;

import com.eXcelerate.entities.Assignment;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public interface ICourseServicesDao {
	List<String> showCourses() throws NoSuchRecordFoundException, SomethingWentWrongException;

	List<Assignment> showAssignments()throws NoSuchRecordFoundException, SomethingWentWrongException;
}
