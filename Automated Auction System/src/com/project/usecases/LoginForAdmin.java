package com.project.usecases;

import java.util.Scanner;

import com.project.beans.Admin;
import com.project.dao.AdminDao;
import com.project.dao.AdminDaoImpl;

public class LoginForAdmin {

	public boolean loginForAdmin() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Username");
		String user = sc.next();
		
		System.out.println("Enter Your Password");
		String pass = sc.next();
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			
			Admin admin = dao.loginAdmin(user, pass);
			
			System.out.println("Welcome "+admin.getName());
			System.out.println("***********************");
			
			return true;
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		return false;
		
	}
	
}
