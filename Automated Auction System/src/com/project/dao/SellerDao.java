package com.project.dao;

import com.project.Exception.SellerException;
import com.project.beans.Seller;

public interface SellerDao {

	public String registerAsASeller(Seller seller);
	
	public Seller loginSeller(String username, String password) throws SellerException;
	
}
