package com.project.usecases;

import com.project.Exception.BuyerException;
import com.project.dao.BuyerDao;
import com.project.dao.BuyerDaoImpl;

public class UpdateTheQuality {

	public void updateTheQuality(int id, String name) {
		
		BuyerDao dao = new BuyerDaoImpl();
		
		
		try {
			dao.updateTheQuality(id, name);
		} catch (BuyerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
