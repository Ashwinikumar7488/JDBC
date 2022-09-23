package com.ty.controller;

import java.sql.Date;
import java.util.Scanner;

import com.ty.dao.UserDAO;
import com.ty.dto.User;

public class InsertUser {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserDAO ud = new UserDAO();
		User c = new User();
		boolean flag = true;
		while (flag) {
			System.out.println("Enter your choice:");
			System.out.println("1. INSERT DETAILS\n2. EXIT");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the first name:");
				String f_name = sc.next();
				c.setFirstName(f_name);
				System.out.println("Enter the last name:");
				String l_name = sc.next();
				c.setLastName(l_name);
				System.out.println("Enter the email id:");
				String email = sc.next();
				c.setEmail(email);
				System.out.println("Enter the password:");
				String password = sc.next();
				c.setPassword(password);
				System.out.println("Enter the phone:");
				Long phone = sc.nextLong();
				c.setPhone(phone);
				System.out.println("Enter the date of birth:");
				String dob = sc.next();
				//Date dob=sc.next();
				c.setDob(dob);
				System.out.println("Enter the gender:");
				String gender = sc.next();
				c.setGender(gender);
				
				String result = ud.insert(c);
				System.out.println(result);
				break;
			case 2:
				flag = false;
				System.out.println("Thank You!");
				break;
			default:
				System.out.println("INVALID CHOICE!!");
			}
		}
	}
}
