package com.project.usecases;

import java.util.Scanner;

import com.project.Exception.ItemException;

public class Start {

	public static void main(String[] args) {
		System.out.println("Welcome to the Automated auction system");
		System.out.println("***************************************");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("*********************************");
			System.out.println("Press 1 for Administrator");
			System.out.println("Press 2 for Seller");
			System.out.println("Press 3 for Buyer");
			System.out.println("Press 4 for exit from the system");
			System.out.println("*********************************");
			
			int c= sc.nextInt();
			
			if(c == 4) {
				break;
			}
			else if(c == 1) {
				System.out.println("Welcome Administrator");
			}
			else if(c == 2) {
				System.out.println("Do you have an account? (Yes/No)");
				String res = sc.next();
				if(res.equalsIgnoreCase("no")) {
					RegisterAsASeller reg = new RegisterAsASeller();
					reg.registerForSeller();
				}
				System.out.println("Do you want to login? (Yes /No)");
				String response = sc.next();
				
				boolean result = false;
				
				if(response.equalsIgnoreCase("yes")) {
					LoginForSeller login = new LoginForSeller();
					result = login.loginForSeller();
				}
				while(result) {
					System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
					System.out.println("Press 1 for creating a list of Item to sell");
					System.out.println("Press 2 for update the item price or quantity");
					System.out.println("Press 3 for adding a new Item in the list");
					System.out.println("Press 4 for removing the Items from the list");
					System.out.println("Press 4 for seeing the sold history");
					System.out.println("Press 5 for exit the seller section");
					System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
					int choice = sc.nextInt();
					
					if(choice == 1) {
						CreateItemList item = new CreateItemList();
						item.createItem();
					}
					else if(choice == 5) {
						break;
					}
					else if(choice == 2) {
						boolean x = true;
						while(x) {
							System.out.println("--------------------------");
							System.out.println("What you want to add?");
							System.out.println("Press 1 for Item Name");
							System.out.println("Press 2 for Item Price");
							System.out.println("Press 3 for No of Items");
							System.out.println("--------------------------");
							
							int ch = sc.nextInt();
							if(ch == 1) {
								UpdateItemName name = new UpdateItemName();
								
								try {
									name.updateItemName();
								} catch (ItemException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if(ch == 2) {
								UpdateItemPrice price = new UpdateItemPrice();
								price.updateItemPrice();
							}
							else if(ch == 3) {
								System.out.println("You want to add No. of items");
							}
							System.out.println("Press 1 for more");
							System.out.println("Press 2 for exit");
							int ch1 = sc.nextInt();
							if(ch1 == 2) {
								x = false;
							}
						}
					}
					
				}
			}
			
			
			
			
		}
		
		System.out.println("Thank you using this application");
		
	}
	
}
