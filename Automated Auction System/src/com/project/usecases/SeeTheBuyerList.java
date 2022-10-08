package com.project.usecases;

import java.util.List;

import com.project.Exception.BuyerException;
import com.project.beans.Buyer;
import com.project.dao.AdminDao;
import com.project.dao.AdminDaoImpl;

public class SeeTheBuyerList {

	public void viewBuyerList(){
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			List<Buyer> buyers = dao.viewTheBuyerList();
			
			buyers.forEach(buyer -> {
				
				System.out.println("Buyer Name : "+buyer.getName());
				System.out.println(buyer.getName()+"'s ID : "+buyer.getUserId());
				System.out.println("Username : "+buyer.getUsername());
				System.out.println("Password : "+buyer.getPassword());
				System.out.println("Email Id : "+buyer.getEmail());
				System.out.println("==================================");
				
			});
			
		} catch (BuyerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
