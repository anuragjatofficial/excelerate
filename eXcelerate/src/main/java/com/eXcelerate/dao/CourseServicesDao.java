package com.eXcelerate.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.eXcelerate.entities.Assignment;
import com.eXcelerate.entities.Course;
import com.eXcelerate.entities.CurrentLoggedInID;
import com.eXcelerate.entities.Student;
import com.eXcelerate.exceptions.NoAccountLoggedInException;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;
import com.eXcelerate.utils.EMutils;

public class CourseServicesDao implements ICourseServicesDao {

	@Override
	public Set<Course> showCourses()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException {
		EntityManager em = null;
		try {
			em = EMutils.getEntityManager();
			Student student = em.find(Student.class, CurrentLoggedInID.CurrentLoggedInStudentID);
			if (student == null) {
				throw new NoAccountLoggedInException("oops you forgot to login : ) ");
			}
			Set<Course> courses = student.getCourses();
			if (courses.isEmpty()) {
				throw new NoSuchRecordFoundException("you haven't assinged to any course yet");
			}

//			String showCourses = "SELECT c.courseName FROM Course c where c.courseStatus = :courseStatus";
//			Query qu = em.createQuery(showCourses);
//			qu.setParameter("courseStatus", State.ACTIVE);
//			@SuppressWarnings("unchecked")
//			List<String> courseNames = (List<String>) qu.getResultList();
//			if (courseNames.isEmpty()) {
//				
//			}
			return courses;
		} catch (PersistenceException p) {
			throw new SomethingWentWrongException("oop's a problem occured , please try again later");
		} finally {
			if(em!=null) {
				em.close();
			}
		}
	}

	@Override
	public List<Assignment> showAssignments()
			throws NoSuchRecordFoundException, SomethingWentWrongException, NoAccountLoggedInException {
		EntityManager em = null;
		try {
			Set<Course> courses = showCourses();
			List<Assignment> assignments = new ArrayList<>();
			for(Course course: courses) {
				assignments.addAll(course.getAssignments());
			}
			if(assignments.isEmpty()) {
				throw new NoSuchRecordFoundException("you have not given any assignments so far");
			}
			return assignments;
		} catch (PersistenceException p) {
			throw new SomethingWentWrongException("oop's a problem occured , please try again later");
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

}
