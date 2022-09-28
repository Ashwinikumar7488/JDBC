package com.ty.controller;

import java.util.List;
import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;

public class CartGetAll {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		CartDAO cd = new CartDAO();
		Cart c = new Cart();
		boolean flag = true;
		while (flag) {
			System.out.println("Enter your choice:");
			System.out.println("1. GET ALL DETAILS\n2. EXIT");
			int choice = s.nextInt();
			switch (choice) {
			case 1:
				List<Cart> l = cd.getAll();
				System.out.println(l);
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
