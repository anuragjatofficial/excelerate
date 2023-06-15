package com.eXcelerate.services;

import java.util.List;

import com.eXcelerate.dao.CourseServicesDao;
import com.eXcelerate.dao.ICourseServicesDao;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public class CourseServices implements ICourseServices{

	@Override
	public List<String> showCourses() throws NoSuchRecordFoundException, SomethingWentWrongException {
		ICourseServicesDao iCsDao = new  CourseServicesDao();
		return iCsDao.showCourses();
	}

}
