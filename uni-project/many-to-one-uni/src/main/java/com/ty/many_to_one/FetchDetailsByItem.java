package com.ty.many_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchDetailsByItem {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		Item item = entityManager.find(Item.class, 5);
				
		if(item!=null) {
			System.out.println(item);
		}
		else {
			System.out.println("Details Not Found!");
		}
	}
}
