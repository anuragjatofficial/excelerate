package com.eXcelerate.services;

import java.util.List;

import com.eXcelerate.entities.Assignment;
import com.eXcelerate.entities.Quiz;
import com.eXcelerate.exceptions.NoAccountLoggedInException;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public interface ICourseServices {
	List<String> showCourses()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException;

	List<Assignment> showAssignments()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException;

	List<Quiz> showQuizzes()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException;

}