package com.ty.many_to_one_ex3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchDetailsBySim {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Sim sim = entityManager.find(Sim.class, 1);

		if (sim != null) {
			System.out.println(sim);
		} else {
			System.out.println("Details not found!");
		}
	}
}