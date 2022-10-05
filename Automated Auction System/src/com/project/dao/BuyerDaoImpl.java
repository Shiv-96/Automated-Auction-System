package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.Exception.BuyerException;
import com.project.beans.Buyer;
import com.project.utility.DBUtill;

public class BuyerDaoImpl implements BuyerDao {

	@Override
	public String registerForBuyer(Buyer buyer) {
		
		String message = "Not Registred";
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into buyer (Name, Username, Password, EmailId) values (?, ?, ?, ?) ");
			
			ps.setString(1, buyer.getName());
			ps.setString(2, buyer.getUsername());
			ps.setString(3, buyer.getPassword());
			ps.setString(4, buyer.getEmail());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "You are registered in the system";
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
		
		
		
		return message;
		
	}

	@Override
	public Buyer loginAsaBuyer(String username, String password) throws BuyerException {
		
		Buyer buyer = null;
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from buyer where Username = ? and Password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				String na = rs.getString("Name");
				String user = rs.getString("Username");
				String pass = rs.getString("Password");
				String email = rs.getString("EmailId");
				
				buyer = new Buyer(na, user, pass, email);
				
			}
			else {
				throw new BuyerException("Invalid Credential");
			}
			
			
		} catch (SQLException e) {
			throw new BuyerException(e.getMessage());
		}
		
		return buyer;
		
	}

}
