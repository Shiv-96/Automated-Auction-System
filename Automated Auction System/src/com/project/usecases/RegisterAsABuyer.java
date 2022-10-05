package com.project.usecases;

import java.util.Scanner;

import com.project.beans.Buyer;
import com.project.dao.BuyerDao;
import com.project.dao.BuyerDaoImpl;

public class RegisterAsABuyer {

	public void registerBuyer() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name");
		String name = sc.next();
		
		System.out.println("Enter Username");
		String user = sc.next();
		
		System.out.println("Enter Password");
		String pass = sc.next();
		
		System.out.println("Enter your Email id");
		String email = sc.next();
		
		BuyerDao dao = new BuyerDaoImpl();
		
		Buyer buyer = new Buyer(name, user, pass, email);
		
		String result = dao.registerForBuyer(buyer);
		
		System.out.println(result);
		
	}
	
}
