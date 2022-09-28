package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;

public class CartDelete {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		CartDAO cd = new CartDAO();
		Cart c = new Cart();
		boolean flag = true;
		while (flag) {
			System.out.println("Enter your choice:");
			System.out.println("1. DELETE DETAILS\n2. EXIT");
			int choice = s.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the id:");
				int id = s.nextInt();
				c.setId(id);
				String result = cd.delete(id);
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
