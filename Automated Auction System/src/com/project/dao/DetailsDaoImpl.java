package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.Exception.DetailsExcption;
import com.project.beans.Details;
import com.project.utility.DBUtill;

public class DetailsDaoImpl implements DetailsDao {

	@Override
	public String createDetailsWithItem(Details details) throws DetailsExcption {
		
		String message = "Not Added";
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into details (Item_Id, Item_Name, Item_Price, Item_Category, Seller_Name, Buyer_name) values (?, ?, ?, ?, ?, ?)");
			
			ps.setInt(1, details.getItem_id());
			ps.setString(2, details.getItem_name());
			ps.setInt(3, details.getItem_price());
			ps.setString(4, details.getItem_category());
			ps.setString(5, details.getSeller_name());
			ps.setString(6, details.getBuyer_name());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				
				message = details.getItem_name()+" is belngos to "+details.getBuyer_name();
				
			}
			
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
		
		
		return message;
		
		
	}

}
