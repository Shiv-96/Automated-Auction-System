package com.project.usecases;

import java.util.List;

import com.project.Exception.SellerException;
import com.project.beans.Seller;
import com.project.dao.AdminDao;
import com.project.dao.AdminDaoImpl;

public class SeeTheSellerList {
	
	public void viewTheSellerList(){
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			List<Seller> sellers = dao.viewTheSellerList();
			
			sellers.forEach(seller -> {
				
				System.out.println("Seller Name : "+seller.getName());
				System.out.println(seller.getName()+"'s ID : "+seller.getId());
				System.out.println(seller.getName()+"'s Username : "+seller.getUsername());
				System.out.println(seller.getName()+"'s Password : "+seller.getPassword());
				System.out.println(seller.getName()+"'s Email Id : "+seller.getEmailId());
				System.out.println("==================================================");
				
			});
			
		} catch (SellerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
