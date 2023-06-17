package com.eXcelerate.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.eXcelerate.dao.CourseServicesDao;
import com.eXcelerate.dao.ICourseServicesDao;
import com.eXcelerate.entities.Assignment;
import com.eXcelerate.entities.Course;
import com.eXcelerate.entities.Quiz;
import com.eXcelerate.exceptions.NoAccountLoggedInException;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public class CourseServices implements ICourseServices {

	@Override
	public List<String> showCourses()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException {
		ICourseServicesDao iCsDao = new CourseServicesDao();

		Set<Course> courses = iCsDao.showCourses();
		List<String> courselist = new ArrayList<>();
		for (Course course : courses) {
			courselist.add(course.getCourseName());
		}
		return courselist;
	}

	@Override
	public List<Assignment> showAssignments()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException {
		ICourseServicesDao iCsDao = new CourseServicesDao();
		return iCsDao.showAssignments();
	}

	@Override
	public List<Quiz> showQuizzes()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException {
		ICourseServicesDao iCsDao = new CourseServicesDao();
		return iCsDao.showQuizzes();
	}

}
