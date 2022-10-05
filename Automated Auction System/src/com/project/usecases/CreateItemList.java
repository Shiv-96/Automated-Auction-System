package com.project.usecases;

import java.sql.Date;
import java.util.Scanner;

import com.project.beans.ItemList;
import com.project.beans.Seller;
import com.project.dao.ItemDao;
import com.project.dao.ItemDaoImpl;

public class CreateItemList {

	public void createItem() {
		
		Scanner sc = new Scanner(System.in);
		
		Seller seller = new Seller();
		
		System.out.println("Enter the Item name");
		String name = sc.next();
		
		System.out.println("Enter the Price");
		int price = sc.nextInt();
		
		System.out.println("Enter the Item Count");
		int count = sc.nextInt();
		
		System.out.println("Enter the status Sold / Unsold");
		String status = sc.next();
		
		System.out.println("Enter the Category");
		String category = sc.next();
		
		System.out.println("Enter your Name");
		String owner = sc.next();
		
		ItemDao dao = new ItemDaoImpl();
		
		ItemList item = new ItemList(name, price, count, status, category, owner);
		
		String result = dao.createItemList(item);
		
		System.out.println(result);
		
	}
	
}
