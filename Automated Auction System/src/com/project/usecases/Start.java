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
				System.out.println("Do you have an account? (Yes / No)");
				String res = sc.next();
				
				if(res.equalsIgnoreCase("no")) {
					
					RegisterAsaAdministrator admin = new RegisterAsaAdministrator();
					
					admin.registerForAdministrator();
					
				}
				else if(res.equalsIgnoreCase("yes")) {
					System.out.println("Do you want to login? (Yes / No)");
					String response = sc.next();
					
					boolean result = true;
					
					if(response.equalsIgnoreCase("yes")) {
						LoginForAdmin login = new LoginForAdmin();
						
						login.loginForAdmin();
					}
					else if(response.equalsIgnoreCase("no")) {
						break;
					}
					else {
						System.out.println("Please choose correct option");
					}
					while(result) {
						System.out.println("++++++++++++++++++++++++++++++++++++++");
						System.out.println("Press 1 for See the buyer list");
						System.out.println("Press 2 for See the Seller list");
						System.out.println("Press 3 for See the dalily dispute result");
						System.out.println("Press 4 for see the selling report");
						System.out.println("Press 5 for solve the dispute report");
						System.out.println("Press 6 for exit the Admin section");
						System.out.println("+++++++++++++++++++++++++++++++++++++++++");
						
						int choice = sc.nextInt();
						
						if(choice == 1) {
							
							SeeTheBuyerList buyer = new SeeTheBuyerList();
							
							buyer.viewBuyerList();
							
						}
						else if(choice == 2) {
							
							SeeTheSellerList seller = new SeeTheSellerList();
							seller.viewTheSellerList();
						}
						
					}
				}
				else {
					System.out.println("Please choose correct option");
				}
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
					System.out.println("Press 5 for seeing the sold history");
					System.out.println("Press 6 for exit the seller section");
					System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
					int choice = sc.nextInt();
					
					if(choice == 1) {
						CreateItemList item = new CreateItemList();
						item.createItem();
					}
					else if(choice == 6) {
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
								UpdateItemCount count = new UpdateItemCount();
								count.updateCount();
								
							}
							System.out.println("Press 1 for more");
							System.out.println("Press 2 for exit");
							int ch1 = sc.nextInt();
							if(ch1 == 2) {
								x = false;
							}
						}
					}
					else if(choice == 3) {
						boolean x = true;
						while(x) {
							CreateItemList item = new CreateItemList();
							item.createItem();
							
							System.out.println("Press 1 for more");
							System.out.println("Press 2 for exit");
							int ch1 = sc.nextInt();
							if(ch1 == 2) {
								x = false;
							}
							
						}
						
					}
					else if(choice == 4) {
						boolean x = true;
						while(x) {
							RemoveTheItem remove = new RemoveTheItem();
							remove.removeTheItem();
							
							while(true) {
								System.out.println("Do you want to delete more (Yes/No)");
								String ch = sc.next();
								if(ch.equalsIgnoreCase("Yes")) {
									x = true;
									break;
								}
								else if(ch.equalsIgnoreCase("No")) {
									x = false;
									break;
								}
								else {
									System.out.println("Please Enter correct option");
								}
							}
						}
					}
					else if(choice == 5) {
						ViewSoldItem sold = new ViewSoldItem();
						sold.getAllSoldItemList();
					}
				}
			}
			else if(c == 3) {
				System.out.println("Do you have an account (Yes / No)");
				String choice = sc.next();
				if(choice.equalsIgnoreCase("no")) {
					RegisterAsABuyer register = new RegisterAsABuyer();
					register.registerBuyer();
				}
				System.out.println("Do you want to login? (Yes /No)");
				String response = sc.next();
				
				boolean result = false;
				
				if(response.equalsIgnoreCase("yes")) {
					LoginForBuyer login = new LoginForBuyer();
					result = login.loginasaBuyer();
				}
				while(result) {
					System.out.println("+++++++++++++++++++++++++++++++++++");
					System.out.println("Press 1 for Search and view Items by category");
					System.out.println("Press 2 for select and view all the seller and also their Item category wise");
					System.out.println("Press 3 for select an items to buy");
					System.out.println("Press 4 for exit the buyer section");
					System.out.println("+++++++++++++++++++++++++++++++++++++");
					
					int ch = sc.nextInt();
					
					if(ch == 4) {
						break;
					}
					else if(ch == 1) {
						ViewItemsByCategory cat = new ViewItemsByCategory();
						cat.viewItemByCategory();
					}
					else if(ch == 2) {
						ViewAllTheSeller seller = new ViewAllTheSeller();
						seller.viewAllTheSeller();
					}
					else if(ch == 3) {
						SelectItemToBuy buy = new SelectItemToBuy();
						buy.selectItemToBuy();
					}
				}
			}
		}
		
		System.out.println("Thank you using this application");
		
	}
	
}
