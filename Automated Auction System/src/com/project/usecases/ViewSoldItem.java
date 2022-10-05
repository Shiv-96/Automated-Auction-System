package com.project.usecases;

import java.util.List;

import com.project.Exception.ItemException;
import com.project.beans.ItemList;
import com.project.dao.ItemDao;
import com.project.dao.ItemDaoImpl;

public class ViewSoldItem {

	public void getAllSoldItemList() {
	
		ItemDao dao = new ItemDaoImpl();
		
		try {
			
			List<ItemList> items = dao.getSoldItemList();
			
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
			
			
		} catch (ItemException ie) {
			System.out.println(ie.getMessage());
		}
		
	}
	
	
}
