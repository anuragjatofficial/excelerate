package com.eXcelerate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.eXcelerate.entities.Instructor;
import com.eXcelerate.entities.Student;
import com.eXcelerate.exceptions.SomethingWentWrongException;
import com.eXcelerate.utils.EMutils;

public class RegisterDao implements IRegisterDao {

	@Override
	public String registerInstructor(Instructor instructor) throws SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			// creating entityManager from EmUtils class
			em = EMutils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(instructor);
			et.commit();
			return "Instuctor registered succesfully ..!";
		} catch (PersistenceException p) {
			et.rollback();
			// throwing SomethingWentWrongException to hide any problem from user
			throw new SomethingWentWrongException("unable to register Instuctor please try again later");
		} finally {
			em.close();
		}
	}

	@Override
	public String registerStudent(Student student) throws SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			// creating entityManager from EmUtils class
			em = EMutils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(student);
			et.commit();
			return "Student registered succesfully ..!";
		} catch (PersistenceException p) {
			et.rollback();
			// throwing SomethingWentWrongException to hide any problem from user
			throw new SomethingWentWrongException("unable to register Student please try again later");
		} finally {
			if(em!=null) {
				em.close();
			}
		}
	}

}
