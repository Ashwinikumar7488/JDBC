package com.ty.one_to_many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RetrieveDetails {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Mobile mobile = entityManager.find(Mobile.class, 1);

		if (mobile != null) {
			/*
			 * for (Sim sims : mobile.getSims()) { System.out.println(mobile); }
			 */
			System.out.println(mobile);
		} else {
			System.out.println("Details not found!");
		}
	}
}
