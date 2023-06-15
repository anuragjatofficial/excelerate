package com.eXcelerate.services;

import java.util.List;

import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public interface ICourseServices {
	List<String> showCourses() throws NoSuchRecordFoundException, SomethingWentWrongException;
}
