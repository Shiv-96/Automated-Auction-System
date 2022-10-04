package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.beans.ItemList;
import com.project.beans.Seller;
import com.project.utility.DBUtill;

public class ItemDaoImpl implements ItemDao {

	@Override
	public String createItemList(ItemList item) {
		String message = "Not Added";
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into SellerItemList (Item_name, Item_Price, Item_Quantity, Sold_Unsold, category, Owner) value(?, ?, ?, ?, ?, ?)");
			
			Seller seller = new Seller();
			
			ps.setString(1, item.getItem_name());
			ps.setInt(2, item.getItem_price());
			ps.setInt(3, item.getItem_quantity());
			ps.setString(4, item.getItem_status());
			ps.setString(5, item.getItem_category());
			ps.setString(6, seller.getName());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = item.getItem_name()+ " is added in the list"; 
			}
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		
		
		return message;
	}

}
