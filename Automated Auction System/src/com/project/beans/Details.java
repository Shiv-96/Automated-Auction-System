package com.project.beans;

import java.sql.Date;

public class Details {

	private int item_id;
	private String item_name;
	private int item_price;
	private String item_category;
	private String seller_name;
	private String buyer_name;
	private Date purchase_Date;
	
	public Details() {
		
	}

	
	
	public Details(int item_id, String item_name, int item_price, String item_category, String seller_name,
			String buyer_name) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_price = item_price;
		this.item_category = item_category;
		this.seller_name = seller_name;
		this.buyer_name = buyer_name;
	}



	public Details(int item_id, String item_name, int item_price, String item_category, String seller_name,
			String buyer_name, Date purchase_Date) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_price = item_price;
		this.item_category = item_category;
		this.seller_name = seller_name;
		this.buyer_name = buyer_name;
		this.purchase_Date = purchase_Date;
	}

	public int getItem_id() {
		return item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public int getItem_price() {
		return item_price;
	}

	public String getItem_category() {
		return item_category;
	}

	public String getSeller_name() {
		return seller_name;
	}

	public String getBuyer_name() {
		return buyer_name;
	}

	public Date getPurchase_Date() {
		return purchase_Date;
	}

	@Override
	public String toString() {
		return "Details [item_id=" + item_id + ", item_name=" + item_name + ", item_price=" + item_price
				+ ", item_category=" + item_category + ", seller_name=" + seller_name + ", buyer_name=" + buyer_name
				+ ", purchase_Date=" + purchase_Date + "]";
	}
	
	
}
