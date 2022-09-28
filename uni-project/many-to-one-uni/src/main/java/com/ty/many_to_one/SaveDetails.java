package com.ty.many_to_one;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveDetails {

	public static void main(String[] args) {

		FoodOrder foodOrder = new FoodOrder();
		foodOrder.setToWhom("Sanjeev");
		foodOrder.setStatus("Not Delivered");
		
		Item item1 = new Item();
		item1.setName("Vada");
		item1.setQuantity(3);
		item1.setCost(40.00);
		
		Item item2 = new Item();
		item2.setName("Masala-Dosa");
		item2.setQuantity(1);
		item2.setCost(50.00);
		
		Item item3 = new Item();
		item3.setName("Pizza");
		item3.setQuantity(1);
		item3.setCost(120.00);
		
		List<Item> items= new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		
		item1.setFoodOrder(foodOrder);
		item2.setFoodOrder(foodOrder);
		item3.setFoodOrder(foodOrder);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(foodOrder);
		entityManager.persist(item1);
		entityManager.persist(item2);
		entityManager.persist(item3);
		entityTransaction.commit();
	}
}
