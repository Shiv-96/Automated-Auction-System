package com.project.usecases;

import java.util.Scanner;

import com.project.Exception.BuyerException;
import com.project.Exception.DetailsExcption;
import com.project.Exception.ItemException;
import com.project.beans.Details;
import com.project.beans.ItemList;
import com.project.dao.BuyerDao;
import com.project.dao.BuyerDaoImpl;
import com.project.dao.DetailsDao;
import com.project.dao.DetailsDaoImpl;
import com.project.dao.ItemDao;
import com.project.dao.ItemDaoImpl;

public class SelectItemToBuy {
	
	public void selectItemToBuy(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your name");
		String name = sc.next();
		
		System.out.println("Enter Item name you want to buy");
		String itemName = sc.next();
		
		System.out.println("Enter Item Category");
		String category = sc.next();
		
		System.out.println("Enter the Item id");
		int id = sc.nextInt();
		
		System.out.println("Is the Quality Good");
		String isGood = sc.next();
		
		BuyerDao dao = new BuyerDaoImpl();
		
		DetailsDao dao1 = new DetailsDaoImpl();
		
		ItemDao dao2 = new ItemDaoImpl();
		
		ItemList item;
		
		if(isGood.equalsIgnoreCase("yes")) {
			
			
			
			try {
				item = dao.updateSoldUnsoldValue(itemName, category, id);
				
				int item_id = +item.getItem_id();
				String item_name = item.getItem_name();
				int item_price = item.getItem_price();
				String item_category = item.getItem_category();
				String owner = item.getItem_owner();
				
				Details details = new Details(item_id, item_name, item_price, item_category, owner, name);
				
				
				
				try {
					String result = dao1.createDetailsWithItem(details);
					
					System.out.println(result);
				} catch (DetailsExcption e) {
					// TODO Auto-generated catch block
					e.getMessage();
				}
				
				try {
					boolean x = dao2.removeTheItemFromTheList(item_id, itemName);
					
					if(x == true) {
						System.out.println("Remove from the seller section");
					}
					else
						System.out.println("Item is not there");
					
				} catch (ItemException e) {
					// TODO Auto-generated catch block
					e.getMessage();
				}
				
				
			} catch (BuyerException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			
		}
		else {
			UpdateTheQuality quality = new UpdateTheQuality();
			
			quality.updateTheQuality(id, itemName);
			
		}
		
	}
	
}
