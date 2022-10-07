package com.project.usecases;

import java.util.Scanner;

import com.project.beans.Admin;
import com.project.dao.AdminDao;
import com.project.dao.AdminDaoImpl;

public class RegisterAsaAdministrator {

	public void registerForAdministrator() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name");
		String name = sc.next();
		
		System.out.println("Enter Username");
		String user = sc.next();
		
		System.out.println("Enter password");
		String pass = sc.next();
		
		System.out.println("Enter Email id");
		String email = sc.next();
		
		AdminDao dao = new AdminDaoImpl();
		
		Admin admin = new Admin(name, user, pass, email);
		
		String result = dao.registerAsAdministrator(admin);
		
		System.out.println(result);
		
	}
	
	
}
