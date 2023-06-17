package com.eXcelerate.services;

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

}
