package com.project.usecases;

import java.util.Scanner;

import com.project.beans.Seller;
import com.project.dao.SellerDao;
import com.project.dao.SellerDaoImpl;

public class LoginForSeller {

	public boolean loginForSeller() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your username");
		String uname = sc.next();
		
		System.out.println("Enter your password");
		String pass = sc.next();
		
		SellerDao dao = new SellerDaoImpl();
		
		try {
			
			Seller seller = dao.loginSeller(uname, pass);
			
			System.out.println("Welcome "+seller.getName());
			System.out.println("********************");
			return true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
}
