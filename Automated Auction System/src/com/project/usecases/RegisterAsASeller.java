package com.project.usecases;

import java.util.Scanner;

import com.project.beans.Seller;
import com.project.dao.SellerDao;
import com.project.dao.SellerDaoImpl;

public class RegisterAsASeller {

	public void registerForSeller() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name");
		String name = sc.next();
		
		System.out.println("Enter Username");
		String user = sc.next();
		
		System.out.println("Enter Password");
		String pass = sc.next();
		
		System.out.println("Enter your Email id");
		String email = sc.next();
		
		SellerDao dao = new SellerDaoImpl();
		
		Seller seller = new Seller(name, user, pass, email);
		
		String result = dao.registerAsASeller(seller);
		
		System.out.println(result);
		
	}
	
}
