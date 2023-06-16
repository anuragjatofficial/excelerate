package com.eXcelerate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.eXcelerate.entities.Assignment;
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
			String showCourses = "SELECT c.courseName FROM Course c where c.courseStatus = :courseStatus";
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

	@Override
	public List<Assignment> showAssignments() throws NoSuchRecordFoundException, SomethingWentWrongException {
		EntityManager em = null;
		try {
			em = EMutils.getEntityManager();
			String showAssignments = "SELECT c.assignments FROM Course c";
			Query qu = em.createQuery(showAssignments);
			List<Assignment> resultList = qu.getResultList();
			if(resultList.isEmpty())throw new NoSuchRecordFoundException("you haven't given any assignments");
			return resultList;
		} catch (PersistenceException p) {
			throw new SomethingWentWrongException("oop's a problem occured , please try again later");
		} finally {
			if(em!=null) em.close();
		}
//		return null;
	}

}
