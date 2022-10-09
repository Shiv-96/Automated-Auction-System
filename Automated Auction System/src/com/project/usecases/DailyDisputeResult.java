package com.project.usecases;

import com.project.Exception.ItemException;
import com.project.dao.ItemDao;
import com.project.dao.ItemDaoImpl;

public class DailyDisputeResult {

	public void disputeResult() {
		
		ItemDao dao = new ItemDaoImpl();
		
		try {
			String result = dao.getDisputeReport();
			
			System.out.println(result);
			
		} catch (ItemException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	}
	
}
