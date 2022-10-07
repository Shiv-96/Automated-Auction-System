package com.project.dao;

import com.project.Exception.AdminException;
import com.project.beans.Admin;

public interface AdminDao {

	public String registerAsAdministrator(Admin admin);
	
	public Admin loginAdmin(String username, String password) throws AdminException;
	
}
