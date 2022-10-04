package com.project.dao;

import com.project.Exception.ItemException;
import com.project.beans.ItemList;

public interface ItemDao {

	public String createItemList(ItemList item);
	
	public String updateItemName(String oldItem, String newItem) throws ItemException;
	
	public String updateItemPrice(int price, String name, int newPrice);
	
}
