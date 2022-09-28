package com.ty.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Company;
import com.ty.dto.GST;

public class SaveCompanyDetails {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Company company = new Company();
		company.setName("TEST YANTRA");
		company.setAddress("KHATRIGUPE");
		
		GST gst = new GST();
		gst.setNumber("AJHDJJD56357");
		gst.setStatus("REGISTERED");
		
		gst.setCompany(company);
		
		entityTransaction.begin();
		entityManager.persist(company);
		entityManager.persist(gst);
		entityTransaction.commit();
	}
}
