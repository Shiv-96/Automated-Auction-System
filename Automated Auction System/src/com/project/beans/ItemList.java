package com.project.beans;


public class ItemList {

	private int item_id;
	private String item_name;
	private int item_price;
	private int item_quantity;
	private String item_status;
	private String item_category;
	private String item_owner;
	
	public ItemList() {
		// TODO Auto-generated constructor stub
	}

	public ItemList(String item_name, int item_price, int item_quantity, String item_status, String item_category, String item_owner) {
		super();
		this.item_name = item_name;
		this.item_price = item_price;
		this.item_quantity = item_quantity;
		this.item_status = item_status;
		this.item_category = item_category;
		this.item_owner = item_owner;
		
	}

	public ItemList(int item_id, String item_name, int item_price, int item_quantity, String item_status,
			String item_category, String item_owner) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_price = item_price;
		this.item_quantity = item_quantity;
		this.item_status = item_status;
		this.item_category = item_category;
		this.item_owner = item_owner;
	}
	
	

	public ItemList(int item_id, String item_name, int item_price, String item_category, String item_owner) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_price = item_price;
		this.item_category = item_category;
		this.item_owner = item_owner;
	}

	public String getItem_name() {
		return item_name;
	}
	
	public String getItem_owner() {
		return item_owner;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public int getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}

	public String getItem_status() {
		return item_status;
	}

	public void setItem_status(String item_status) {
		this.item_status = item_status;
	}

	public String getItem_category() {
		return item_category;
	}

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	public int getItem_id() {
		return item_id;
	}

	@Override
	public String toString() {
		return "ItemList [item_id=" + item_id + ", item_name=" + item_name + ", item_price=" + item_price
				+ ", item_quantity=" + item_quantity + ", item_status=" + item_status + ", item_category="
				+ item_category + "]";
	}
	
	
	
}
