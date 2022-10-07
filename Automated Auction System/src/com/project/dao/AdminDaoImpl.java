package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.Exception.AdminException;
import com.project.beans.Admin;
import com.project.utility.DBUtill;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String registerAsAdministrator(Admin admin) {
		
		String message = "Not registered";
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into Admin (Admin_Name, username, password, Admin_Email_Id) values (?, ?, ?, ?)");
			
			ps.setString(1, admin.getName());
			ps.setString(2, admin.getUsername());
			ps.setString(3, admin.getPassword());
			ps.setString(4, admin.getEmailId());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = admin.getName()+" is Registered in the System as a Administrator";
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return message;
		
		
	}

	@Override
	public Admin loginAdmin(String username, String password) throws AdminException {
		
		Admin admin = null;
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from admin where username = ? and password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				String na = rs.getString("Admin_Name");
				String user = rs.getString("username");
				String pass = rs.getString("password");
				String email = rs.getString("Admin_Email_Id");
				
				admin = new Admin(na, user, pass, email);
				
			}
			else {
				throw new AdminException("Invalid Credential");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new AdminException(e.getMessage());
			
		}
		
		return admin;
		
	}

	
	
}
