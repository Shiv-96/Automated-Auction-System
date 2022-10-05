package com.project.usecases;

import java.util.List;
import java.util.Scanner;

import com.project.beans.ItemList;
import com.project.dao.BuyerDao;
import com.project.dao.BuyerDaoImpl;

public class ViewItemsByCategory {

	public void viewItemByCategory() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the category name");
		String cat = sc.next();
		
		BuyerDao dao = new BuyerDaoImpl();
		
		try {
			
			List<ItemList> items = dao.searchItemByCategory(cat);
			
			items.forEach(e -> {
				System.out.println("Items Details:-");
				System.out.println("----------------");
				System.out.println("Id : "+e.getItem_id());
				System.out.println("Name : "+e.getItem_name());
				System.out.println("Price : "+e.getItem_price());
				System.out.println("Quantity : "+e.getItem_quantity());
				System.out.println("Status : "+e.getItem_status());
				System.out.println("Category : "+e.getItem_category());
				System.out.println("Owner : "+e.getItem_owner());
				
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			});
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
