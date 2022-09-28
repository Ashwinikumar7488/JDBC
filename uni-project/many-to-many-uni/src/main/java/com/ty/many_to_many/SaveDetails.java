package com.ty.many_to_many;

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

		/*
		 * Student student1 = new Student(); student1.setName("Ashwini");
		 * student1.setEmail("ashwini46376@gmail.com");
		 */

		Student student2 = new Student();
		student2.setName("Sandesh");
		student2.setEmail("sandesh@gmail.com");

		Course course1 = new Course();
		course1.setName("Maths");
		course1.setCost(250.0);

		Course course2 = new Course();
		course2.setName("English");
		course2.setCost(300.0);

		Course course3 = new Course();
		course3.setName("Science");
		course3.setCost(350.0);

		Course course4 = new Course();
		course4.setName("Hindi");
		course4.setCost(200.0);
		
		Course course5 = new Course();
		course4.setName("Social Studies");
		course4.setCost(280.0);

		List<Course> courses = new ArrayList<Course>();
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		courses.add(course4);
		
		//To add existing courses and a new course to Student2
		Course c1 = entityManager.find(Course.class, 1);
		Course c2 = entityManager.find(Course.class, 3);

		List<Course> courses2 = new ArrayList<Course>();
		courses2.add(c1);
		courses2.add(c2);
		courses2.add(course5);
		student2.setCourses(courses2);

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		/*
		 * entityManager.persist(student1); entityManager.persist(course1);
		 * entityManager.persist(course2); entityManager.persist(course3);
		 * entityManager.persist(course4);
		 */
		entityManager.persist(student2);
		entityManager.persist(course5);
		entityTransaction.commit();
	}
}
