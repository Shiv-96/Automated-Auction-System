package com.project.dao;

import com.project.Exception.DetailsExcption;
import com.project.beans.Details;

public interface DetailsDao {

	public String createDetailsWithItem(Details details) throws DetailsExcption;
	
}
