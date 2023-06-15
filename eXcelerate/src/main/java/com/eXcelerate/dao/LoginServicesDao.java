package com.eXcelerate.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.eXcelerate.entities.CurrentLoggedInID;
import com.eXcelerate.entities.Instructor;
import com.eXcelerate.entities.State;
import com.eXcelerate.entities.Student;
import com.eXcelerate.exceptions.NoSuchRecordFoundException;
import com.eXcelerate.exceptions.SomethingWentWrongException;
import com.eXcelerate.utils.EMutils;

public class LoginServicesDao implements ILoginServicesDao {

	@Override
	public Boolean LoginInstructor(String username, String password)
			throws NoSuchRecordFoundException, SomethingWentWrongException {
		EntityManager em = null;
		try {
			em = EMutils.getEntityManager();
			String loginQuery = "SELECT ins FROM Instructor ins WHERE ins.username = :username and ins.password = :password and ins.accountStatus = :status";
			Query qu = em.createQuery(loginQuery);
			qu.setParameter("username", username);
			qu.setParameter("password", password);
			qu.setParameter("status", State.ACTIVE);
			Instructor instructor = (Instructor) qu.getSingleResult();

			if (instructor != null) {
				CurrentLoggedInID.CurrentLoggedInInstructorsID = instructor.getId();
				return true;
			}
		} catch (NoResultException e) {
			throw new NoSuchRecordFoundException("wrong username or passowrd");
		} catch (PersistenceException p) {
			p.printStackTrace();
			throw new SomethingWentWrongException("unable to login please try later");
		} finally {
			em.close();
		}
		return false;
	}

	@Override
	public Boolean LoginStudent(String username, String password)
			throws NoSuchRecordFoundException, SomethingWentWrongException {
		EntityManager em = null;
		try {
			em = EMutils.getEntityManager();
			String loginQuery = "SELECT stu FROM Student stu WHERE stu.username = :username and stu.password = :password and stu.accountStatus = :status";
			Query qu = em.createQuery(loginQuery);
			qu.setParameter("username", username);
			qu.setParameter("password", password);
			qu.setParameter("status", State.ACTIVE);
			Student student = (Student) qu.getSingleResult();

			if (student != null) {
				CurrentLoggedInID.CurrentLoggedInStudentID = student.getId();
				return true;
			}
		} catch (NoResultException e) {
			throw new NoSuchRecordFoundException("wrong username or passowrd");
		} catch (PersistenceException p) {
			p.printStackTrace();
			throw new SomethingWentWrongException("unable to login please try later");
		} finally {
			em.close();
		}
		return false;
	}

}