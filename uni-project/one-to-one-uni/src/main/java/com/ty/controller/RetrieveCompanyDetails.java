package com.ty.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.dto.Company;
import com.ty.dto.GST;

public class RetrieveCompanyDetails {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		GST gst =entityManager.find(GST.class, 1);
		
		Company company = gst.getCompany();
		
		if(company!=null) {
			System.out.println("========COMPANY DETAILS============");
			System.out.println("ID: "+company.getId());
			System.out.println("NAME: "+company.getName());
			System.out.println("ADDRESS"+company.getAddress());
		}
		else {
			System.out.println("COMPANY NOT FOUND!");
		}
	}
}
