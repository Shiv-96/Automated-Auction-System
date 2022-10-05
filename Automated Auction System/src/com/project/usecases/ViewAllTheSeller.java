package com.project.usecases;

import java.util.List;

import com.project.beans.ItemList;
import com.project.dao.BuyerDao;
import com.project.dao.BuyerDaoImpl;

public class ViewAllTheSeller {

	public void viewAllTheSeller() {
		
		BuyerDao dao = new BuyerDaoImpl();
		
		try {
			
			List<ItemList> items = dao.viewAllTheSeller();
			
			items.forEach( e -> {
				System.out.println("Items Details:-");
				System.out.println("----------------");
				System.out.println("Id : "+e.getItem_id());
				System.out.println("Name : "+e.getItem_name());
				System.out.println("Category : "+e.getItem_category());
				System.out.println("Owner : "+e.getItem_owner());
				
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			});
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
