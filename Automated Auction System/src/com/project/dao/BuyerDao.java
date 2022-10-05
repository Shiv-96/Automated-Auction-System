package com.project.dao;

import com.project.Exception.BuyerException;
import com.project.beans.Buyer;

public interface BuyerDao {

	public String registerForBuyer(Buyer buyer);
	
	public Buyer loginAsaBuyer(String username, String password) throws BuyerException;
	
}
