package com.ty.many_to_many_ex2;

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
		 * Teacher teacher1 = new Teacher(); teacher1.setName("R.K. Rahi");
		 * teacher1.setGender("Male");
		 */

		Teacher teacher2 = new Teacher();
		teacher2.setName("B.K. Roy");
		teacher2.setGender("Male");

		/*
		 * Subject subject1 = new Subject(); subject1.setName("Hindi");
		 * subject1.setDays(90);
		 * 
		 * Subject subject2 = new Subject(); subject2.setName("Maths");
		 * subject2.setDays(120);*/
		 

		Subject subject3 = new Subject();
		subject3.setName("Science");
		subject3.setDays(110);

		Subject subject4 = new Subject();
		subject4.setName("English");
		subject4.setDays(80);

		/*
		 * List<Subject> subjects = new ArrayList<Subject>(); subjects.add(subject1);
		 * subjects.add(subject2); subjects.add(subject3);
		 */

		Subject s1 = entityManager.find(Subject.class, 3);

		List<Subject> subjects2 = new ArrayList<Subject>();
		subjects2.add(subject4);
		subjects2.add(s1);

		teacher2.setSubjects(subjects2);
		// teacher1.setSubjects(subjects);

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		// entityManager.persist(teacher1);
		// entityManager.persist(subject1);
		// entityManager.persist(subject2);
		entityManager.persist(teacher2);
		entityManager.persist(subject4);
		entityTransaction.commit();
	}
}
