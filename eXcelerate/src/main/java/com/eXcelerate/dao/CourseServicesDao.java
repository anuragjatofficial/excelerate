package com.eXcelerate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.eXcelerate.entities.State;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;
import com.eXcelerate.utils.EMutils;

public class CourseServicesDao implements ICourseServicesDao {

	@Override
	public List<String> showCourses() throws NoSuchRecordFoundException, SomethingWentWrongException {
		EntityManager em = null;
		try {
			em = EMutils.getEntityManager();
			String showCourses = "SELECT c.courseName FROM Course c where e.courseStatus = :courseStatus";
			Query qu = em.createQuery(showCourses);
			qu.setParameter("courseStatus", State.ACTIVE);
			@SuppressWarnings("unchecked")
			List<String> courseNames = (List<String>) qu.getResultList();
			if (courseNames.isEmpty()) {
				throw new NoSuchRecordFoundException("you haven't assinged to any course yet");
			}
			return courseNames;
		} catch (PersistenceException p) {
			throw new SomethingWentWrongException("oop's a problem occured , please try again later");
		} finally {
			em.close();
		}
	}

}
