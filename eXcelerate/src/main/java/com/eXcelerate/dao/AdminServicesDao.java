package com.eXcelerate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.eXcelerate.entities.Course;
import com.eXcelerate.exceptions.SomethingWentWrongException;
import com.eXcelerate.utils.EMutils;

public class AdminServicesDao implements IAdminServicesDao {

	@Override
	public void addCourses(Course course) throws SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMutils.getEntityManager();
			et = em.getTransaction();
			
			et.begin();
			em.persist(course);
			
			et.commit();
		}catch(PersistenceException p) {
			et.rollback();
			throw new SomethingWentWrongException("oops something went wrong please try later ..!");
		}finally {
			if(em!=null) em.close();
		}
	}

}
