package com.eXcelerate.services;

import java.util.Map;
import java.util.Scanner;

import com.eXcelerate.dao.AdminServicesDao;
import com.eXcelerate.dao.IAdminServicesDao;
import com.eXcelerate.entities.Course;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public class AdminServices implements IAdminServices {

	@Override
	public void addCourses(Course course) throws SomethingWentWrongException {
		IAdminServicesDao iAd = new AdminServicesDao();
		iAd.addCourses(course);
	}

	@Override
	public void assignCoureToStudent(int[] courseIDs, int studentId) throws SomethingWentWrongException, NoSuchRecordFoundException {
		IAdminServicesDao iAd = new AdminServicesDao();
		iAd.assignCoureToStudent(courseIDs,studentId);
	}

	@Override
	public void deleteCourseById(int courseId) throws SomethingWentWrongException, NoSuchRecordFoundException {
		IAdminServicesDao iAd = new AdminServicesDao();
		iAd.deleteCourseById(courseId);
	}

	@Override
	public void deleteStudentById(int studentId) throws SomethingWentWrongException, NoSuchRecordFoundException {
		IAdminServicesDao iAd = new AdminServicesDao();
		iAd.deleteStudentById(studentId);
	}

	@Override
	public void deleteInstructorById(int instrucorID) throws SomethingWentWrongException, NoSuchRecordFoundException {
		IAdminServicesDao iAd = new AdminServicesDao();
		iAd.deleteInstructorById(instrucorID);
	}

	@Override
	public Map<String, Double> showStats(int courseID) throws SomethingWentWrongException, NoSuchRecordFoundException {
		IAdminServicesDao iAd = new AdminServicesDao();
		return iAd.showStats(courseID);
	}

}
