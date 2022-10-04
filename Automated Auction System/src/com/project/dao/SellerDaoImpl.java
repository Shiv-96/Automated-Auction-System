package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.Exception.SellerException;
import com.project.beans.Seller;
import com.project.utility.DBUtill;

public class SellerDaoImpl implements SellerDao {

	@Override
	public String registerAsASeller(Seller seller) {
		
		String message = "Not Registered";
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into seller (name, username, password, emailId) values(?, ?, ?, ?)");
			
			ps.setString(1, seller.getName());
			ps.setString(2, seller.getUsername());
			ps.setString(3, seller.getPassword());
			ps.setString(4, seller.getEmailId());
			
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "You are Registered in this system";
				
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
		
		return message;
		
	}

	@Override
	public Seller loginSeller(String username, String password) throws SellerException {
		
		Seller seller = null;
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from seller where username = ? and password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String na = rs.getString("name");
				String uname = rs.getString("username");
				String pass = rs.getString("password");
				String em = rs.getString("emailId");
				
				seller = new Seller(na, uname, pass, em);
				
			}
			else {
				throw new SellerException("Invalid Credenmtial");
			}
			
		} catch (SQLException e) {
			throw new SellerException(e.getMessage());
		}
		
		return seller;
		
	}

}
