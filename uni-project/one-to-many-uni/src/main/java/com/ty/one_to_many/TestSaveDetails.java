package com.ty.one_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveDetails {

	public static void main(String[] args) {

		Mobile mobile = new Mobile();
		mobile.setName("iPhone 14");
		mobile.setCost(125000.00);

		Sim sim1 = new Sim();
		sim1.setName("Jio Sim");
		sim1.setProvider("RELIANCE JIO");

		Sim sim2 = new Sim();
		sim2.setName("Airtel Sim");
		sim2.setProvider("BHARTI AIRTEL");

		List<Sim> sims = new ArrayList<Sim>();
		sims.add(sim1);
		sims.add(sim2);

		mobile.setSims(sims);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim1);
		entityManager.persist(sim2);
		entityTransaction.commit();
	}
}
