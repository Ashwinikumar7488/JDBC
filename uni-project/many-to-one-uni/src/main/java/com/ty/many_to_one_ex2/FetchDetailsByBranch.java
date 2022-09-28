package com.ty.many_to_one_ex2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchDetailsByBranch {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		Branch branch = entityManager.find(Branch.class, 1);
				
		if(branch!=null) {
			System.out.println("========DETAILS===============");
			System.out.println(branch);
		}
		else {
			System.out.println("Details Not Found!");
		}
	}
}