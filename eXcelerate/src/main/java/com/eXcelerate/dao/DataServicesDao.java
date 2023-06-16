package com.eXcelerate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.eXcelerate.entities.Assignment;
import com.eXcelerate.entities.Course;
import com.eXcelerate.entities.Quiz;
import com.eXcelerate.entities.State;
import com.eXcelerate.entities.Student;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;
import com.eXcelerate.utils.EMutils;

public class DataServicesDao implements IDataServicesDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> showStudents() throws SomethingWentWrongException, NoSuchRecordFoundException {
		EntityManager em = null;
		try {
			em = EMutils.getEntityManager();
			String query = "SELECT s FROM Student s where s.accountStatus = :accStatus";
			Query qu = em.createQuery(query);
			qu.setParameter("accStatus", State.ACTIVE);
			List<Student> resultList = (List<Student>) qu.getResultList();
			if (resultList.isEmpty()) {
				throw new NoSuchRecordFoundException("No active student found in DataBase");
			}
			return resultList;
		} catch (PersistenceException p) {
			throw new SomethingWentWrongException("oop's something went wrong please try later");
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> showCourses() throws SomethingWentWrongException, NoSuchRecordFoundException {
		EntityManager em = null;
		try {
			em = EMutils.getEntityManager();
			String query = "SELECT c FROM Course c where c.courseStatus = :accStatus";
			Query qu = em.createQuery(query);
			qu.setParameter("accStatus", State.ACTIVE);
			List<Course> resultList = (List<Course>) qu.getResultList();
			if (resultList.isEmpty()) {
				throw new NoSuchRecordFoundException("No Course found in DataBase");
			}
			return resultList;
		} catch (PersistenceException p) {
			throw new SomethingWentWrongException("oop's something went wrong please try later");
		} finally {
			em.close();
		}
	}

	@Override
	public void addAssignment(int courseId, Assignment assignment)
			throws SomethingWentWrongException, NoSuchRecordFoundException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMutils.getEntityManager();
			et = em.getTransaction();
			Course course = em.find(Course.class, courseId);
			if (course == null) {
				throw new NoSuchRecordFoundException("can't find any course with id " + courseId);
			}
			et.begin();
			em.merge(course);
			course.getAssignments().add(assignment);
			et.commit();
		} catch (PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("oop's can't add assignment please try later ");
		} finally {
			em.close();
		}
	}

	@Override
	public void addQuiz(int courseId, Quiz quiz) throws SomethingWentWrongException, NoSuchRecordFoundException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMutils.getEntityManager();
			et = em.getTransaction();
			Course course = em.find(Course.class, courseId);
			if (course == null) {
				throw new NoSuchRecordFoundException("can't find any course with id " + courseId);
			}
			et.begin();
			em.merge(course);
			course.getQuizzes().add(quiz);
			et.commit();
		} catch (PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("oop's can't add quiz please try later ");
		} finally {
			em.close();
		}
	}

}
