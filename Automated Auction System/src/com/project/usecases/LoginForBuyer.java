package com.project.usecases;

import java.util.Scanner;

import com.project.Exception.BuyerException;
import com.project.beans.Buyer;
import com.project.dao.BuyerDao;
import com.project.dao.BuyerDaoImpl;

public class LoginForBuyer {

	public boolean loginasaBuyer() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Username");
		String user = sc.next();
		
		System.out.println("Enter your password");
		String pass = sc.next();
		
		BuyerDao dao = new BuyerDaoImpl();
		
		try {
			
			Buyer buyer = dao.loginAsaBuyer(user, pass);
			
			System.out.println("Welcome "+buyer.getName());
			System.out.println("**********************");
			return true;
			
		} catch (BuyerException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		
		return false;
	}
	
}
