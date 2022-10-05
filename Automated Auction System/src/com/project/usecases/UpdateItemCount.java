package com.project.usecases;

import java.util.Scanner;

import com.project.Exception.ItemException;
import com.project.dao.ItemDao;
import com.project.dao.ItemDaoImpl;

public class UpdateItemCount {

	public void updateCount(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name");
		String name = sc.next();
		
		System.out.println("Enter Item Name");
		String itemName = sc.next();
		
		System.out.println("What will be Updated count");
		int count = sc.nextInt();
		
		ItemDao dao = new ItemDaoImpl();
		
		try {
			String result = dao.updateItemCount(name, itemName, count);
			
			System.out.println(result);
			
		} catch (ItemException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
}
