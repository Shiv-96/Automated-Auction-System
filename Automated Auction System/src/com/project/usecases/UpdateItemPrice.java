package com.project.usecases;

import java.util.Scanner;

import com.project.dao.ItemDao;
import com.project.dao.ItemDaoImpl;

public class UpdateItemPrice {

	public void updateItemPrice() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Item Name Which Price you want to update");
		String name = sc.next();
		
		System.out.println("Enter the Price of Item");
		int price = sc.nextInt();
		
		System.out.println("Enter the price you want to update");
		int updatedPrice = sc.nextInt();
		
		ItemDao dao = new ItemDaoImpl();
		
		String result = dao.updateItemPrice(price, name, updatedPrice);
		
		System.out.println(result);
		
	}
	
	
}
