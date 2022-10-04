package com.project.usecases;

//import java.sql.SQLException;
import java.util.Scanner;

import com.project.Exception.ItemException;
import com.project.dao.ItemDao;
import com.project.dao.ItemDaoImpl;

public class UpdateItemName {

	public void updateItemName() throws ItemException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Item name who you want to update");
		String oldName = sc.next();
		
		System.out.println("Enter the new Item name");
		String newItem = sc.next();
		
		ItemDao dao = new ItemDaoImpl();
		
		try {
			
			String result = dao.updateItemName(oldName, newItem);
			
			System.out.println(result);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
		}
			
		
		
	}
	
}
