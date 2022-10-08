package com.project.dao;

import java.util.List;

import com.project.Exception.AdminException;
import com.project.Exception.BuyerException;
import com.project.Exception.SellerException;
import com.project.beans.Admin;
import com.project.beans.Buyer;
import com.project.beans.Seller;

public interface AdminDao {

	public String registerAsAdministrator(Admin admin);
	
	public Admin loginAdmin(String username, String password) throws AdminException;
	
	public List<Buyer> viewTheBuyerList() throws BuyerException;
	
	public List<Seller> viewTheSellerList() throws SellerException;
	
}
