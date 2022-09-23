package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.UserDAO;
import com.ty.dto.User;

public class DeleteUser {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserDAO ud = new UserDAO();
		User c = new User();
		boolean flag = true;
		while (flag) {
			System.out.println("Enter your choice:");
			System.out.println("1. DELETE DETAILS\n2. EXIT");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the email:");
				String email = sc.next();
				c.setEmail(email);
				String result = ud.delete(email);
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
