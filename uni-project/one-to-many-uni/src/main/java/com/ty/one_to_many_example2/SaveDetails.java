package com.ty.one_to_many_example2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveDetails {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		FoodOrder foodOrder = new FoodOrder();
		foodOrder.setToWhom("Ashwini");
		foodOrder.setStatus("Delivered");
		
		Item item1 = new Item();
		item1.setName("Idli");
		item1.setQuantity(2);
		item1.setCost(30.00);
		
		Item item2 = new Item();
		item2.setName("Dosa");
		item2.setQuantity(1);
		item2.setCost(50.00);
		
		Item item3 = new Item();
		item3.setName("Samosa");
		item3.setQuantity(4);
		item3.setCost(48.00);
		
		List<Item> items= new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		
		foodOrder.setItems(items);
		
		EntityTransaction entityTransaction= entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(foodOrder);
		entityManager.persist(item1);
		entityManager.persist(item2);
		entityManager.persist(item3);
		entityTransaction.commit();
	}
}
