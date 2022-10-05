package com.project.usecases;

import java.util.Scanner;

import com.project.Exception.ItemException;
import com.project.dao.ItemDao;
import com.project.dao.ItemDaoImpl;

public class RemoveTheItem {

	public void removeTheItem() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Item Id");
		int id = sc.nextInt();
		
		System.out.println("Enter Item Name");
		String name = sc.next();
		
		ItemDao dao = new ItemDaoImpl();
		try {
			
			if(dao.removeTheItemFromTheList(id, name))
				System.out.println("Item with id "+id+" and name "+name+" is deleted from this system");
			else
				System.out.println("Item with id "+id+" and name "+name+" is not found in this system");
		} catch (ItemException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	}
	
}
