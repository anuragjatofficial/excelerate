package com.eXcelerate.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Anurag Choudhary
 *         <p>
 *         this utility class deals with EmtityManagerFactory & help to create
 *         entity manager factory
 *         </p>
 */

public class EMutils {
	private static EntityManagerFactory emf;
	/**
	 * This static block is responsible to create object of entityManagerFactory
	 */
	static {
		emf = Persistence.createEntityManagerFactory("eXceleratedb");
	}

	/**
	 * @return EntityManager 
	 * this method is used to get the entityManager
	 */
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
