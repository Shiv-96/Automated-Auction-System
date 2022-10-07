package com.project.dao;

import java.util.List;

import com.project.Exception.BuyerException;
import com.project.beans.Buyer;
import com.project.beans.ItemList;

public interface BuyerDao {

	public String registerForBuyer(Buyer buyer);
	
	public Buyer loginAsaBuyer(String username, String password) throws BuyerException;
	
	public List<ItemList> searchItemByCategory(String category) throws BuyerException;
	
	public List<ItemList> viewAllTheSeller() throws BuyerException;
	
	public ItemList updateSoldUnsoldValue(String itemname, String itemCategory, int id) throws BuyerException;
	
	
	public void updateTheQuality(int id, String itemName) throws BuyerException;
	
}
