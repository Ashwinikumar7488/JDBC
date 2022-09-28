package com.ty.one_to_many_example2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchDetailsByFoodOrder {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		
		FoodOrder foodOrder = entityManager.find(FoodOrder.class, 3);
				
		if(foodOrder!=null) {
			System.out.println(foodOrder);
		}
		else {
			System.out.println("Details Not Found!");
		}
	}
}
