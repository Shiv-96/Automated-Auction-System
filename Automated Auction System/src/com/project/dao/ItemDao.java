package com.project.dao;

import java.util.List;

import com.project.Exception.ItemException;
import com.project.beans.ItemList;

public interface ItemDao {

	public String createItemList(ItemList item);
	
	public String updateItemName(String oldItem, String newItem) throws ItemException;
	
	public String updateItemPrice(int price, String name, int newPrice);
	
	public String updateItemCount(String name, String itemName, int count) throws ItemException;
	
	public List<ItemList> getSoldItemList() throws ItemException;
	
	public boolean removeTheItemFromTheList(int itemId, String itemName) throws ItemException;
	
	public String getDisputeReport() throws ItemException;
	
	public String getSellingReport() throws ItemException;
	
	
}
