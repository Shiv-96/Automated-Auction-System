package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.Exception.ItemException;
import com.project.beans.ItemList;
import com.project.utility.DBUtill;

public class ItemDaoImpl implements ItemDao {

	@Override
	public String createItemList(ItemList item) {
		String message = "Not Added";
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into SellerItemList (Item_name, Item_Price, Item_Quantity, Sold_Unsold, category, Owner) value(?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, item.getItem_name());
			ps.setInt(2, item.getItem_price());
			ps.setInt(3, item.getItem_quantity());
			ps.setString(4, item.getItem_status());
			ps.setString(5, item.getItem_category());
			ps.setString(6, item.getItem_owner());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = item.getItem_name()+ " is added in the list"; 
			}
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		
		
		return message;
	}

	@Override
	public String updateItemName(String oldItem, String newItem) throws ItemException {
		
		String message = null;
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update selleritemlist set Item_name = ? where Item_name = ?");
			
			ps.setString(1, newItem);
			ps.setString(2, oldItem);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Item Name is changed from "+oldItem+ " to "+newItem;
			}
			else {
				throw new ItemException("Item is not Changed");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return message;
		
	}

	@Override
	public String updateItemPrice(int price, String name, int newPrice) {
		
		String message = null;
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update selleritemlist set Item_Price = ? where Item_name = ? and Item_Price = ?");
			
			ps.setInt(3, price);
			ps.setInt(1, newPrice);
			ps.setString(2, name);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Price of "+name+" is changed from "+price+ " to "+newPrice;
			}
			else {
				throw new ItemException("Price not changed");
			}
			
		} catch (SQLException | ItemException e) {
			System.out.println(e.getMessage());
		}
		
		return message;
		
	}

}
