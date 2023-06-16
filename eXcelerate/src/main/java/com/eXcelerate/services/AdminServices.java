package com.eXcelerate.services;

import com.eXcelerate.dao.AdminServicesDao;
import com.eXcelerate.dao.IAdminServicesDao;
import com.eXcelerate.entities.Course;
import com.eXcelerate.exceptions.SomethingWentWrongException;

public class AdminServices implements IAdminServices{

	@Override
	public void addCourses(Course course) throws SomethingWentWrongException {
		IAdminServicesDao iAd = new AdminServicesDao();
		 iAd.addCourses(course);
	}
	
}
