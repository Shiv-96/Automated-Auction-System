package com.project.usecases;

import com.project.Exception.ItemException;
import com.project.dao.ItemDao;
import com.project.dao.ItemDaoImpl;

public class DailySellingReport {

	public void sellingReport() {
		
		ItemDao dao = new ItemDaoImpl();
		
		try {
			String message = dao.getSellingReport();
			
			System.out.println(message);
			
		} catch (ItemException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	}
	
}
