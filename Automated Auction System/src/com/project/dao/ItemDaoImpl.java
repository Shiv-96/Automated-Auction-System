package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project.Exception.ItemException;
import com.project.beans.ItemList;
import com.project.utility.DBUtill;

public class ItemDaoImpl implements ItemDao {

	@Override
	public String createItemList(ItemList item) {
		String message = "Not Added";
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into SellerItemList (Item_name, Item_Price, Item_Quantity, Sold_Unsold, category, Owner, Launching_Date) value(?, ?, ?, ?, ?, ?, now())");
			
			ps.setString(1, item.getItem_name());
			ps.setInt(2, item.getItem_price());
			ps.setInt(3, item.getItem_quantity());
			ps.setString(4, item.getItem_status());
			ps.setString(5, item.getItem_category());
			ps.setString(6, item.getItem_owner());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = item.getItem_name()+ " is added in the list"; 
			}
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		
		
		return message;
	}

	@Override
	public String updateItemName(String oldItem, String newItem) throws ItemException {
		
		String message = null;
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update selleritemlist set Item_name = ? where Item_name = ?");
			
			ps.setString(1, newItem);
			ps.setString(2, oldItem);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Item Name is changed from "+oldItem+ " to "+newItem;
			}
			else {
				throw new ItemException("Item is not Changed");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return message;
		
	}

	@Override
	public String updateItemPrice(int price, String name, int newPrice) {
		
		String message = null;
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update selleritemlist set Item_Price = ? where Item_name = ? and Item_Price = ?");
			
			ps.setInt(3, price);
			ps.setInt(1, newPrice);
			ps.setString(2, name);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Price of "+name+" is changed from "+price+ " to "+newPrice;
			}
			else {
				throw new ItemException("Price not changed");
			}
			
		} catch (SQLException | ItemException e) {
			System.out.println(e.getMessage());
		}
		
		return message;
		
	}

	@Override
	public String updateItemCount(String name, String itemName, int count) throws ItemException {
		
		String message = null;
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update selleritemlist set Item_Quantity = ? where Item_name = ? and owner = ?");
			
			ps.setString(3, name);
			ps.setInt(1, count);
			ps.setString(2, itemName);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Now number of "+itemName+" is changed and updated quantity is "+count;
			}
			else {
				throw new ItemException("Quantity not changed");
			}
			
		} catch (SQLException | ItemException e) {
			System.out.println(e.getMessage());
		}
		
		return message;
		
	}

	@Override
	public List<ItemList> getSoldItemList() throws ItemException {
		
		List<ItemList> items = new ArrayList<>();
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from sellerItemList where Sold_Unsold = 'Sold'");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("Item_Id");
				String name = rs.getString("Item_name");
				int price = rs.getInt("Item_Price");
				int count = rs.getInt("Item_Quantity");
				String status = rs.getString("Sold_Unsold");
				String cat = rs.getString("category");
				String own = rs.getString("Owner");
				
				ItemList item = new ItemList(id, name, price, count, status, cat, own);
				
				items.add(item);
				
			}
			
		} catch (SQLException e) {

			throw new ItemException(e.getMessage());
			
		}
		
		if(items.size() == 0) {
			throw new ItemException("Not find any item which is sold.......!!");
		}
		
		return items;
		
	}

	@Override
	public boolean removeTheItemFromTheList(int itemId, String itemName) throws ItemException {
		
		boolean status = false;
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("delete from sellerItemList where Item_Id = ? and Item_name = ?");
			
			ps.setInt(1, itemId);
			ps.setString(2, itemName);

			int rs = ps.executeUpdate();
			
			if(rs > 0) {
				status = true;
			}
			else {
				status = false;
			}
			
		} catch (SQLException e) {
			throw new ItemException(e.getMessage());
		}
		
		return status;
	}

	@Override
	public String getDisputeReport() throws ItemException {
		
		String message = "Don't have any problem on the Item";
		
		try (Connection conn  = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select Launched_On, category, count(*)as Number_Of_Problem from sellerItemList where quality = 'Bad'");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Date launch = rs.getDate("Launched_On");
				String category = rs.getString("category");
				int problem = rs.getInt("Number_Of_Problem");
				
				message = "In "+category+" section we have "+problem+" problem on "+launch;
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return message;
		
	}

	@Override
	public String getSellingReport() throws ItemException {
		
		String message = "Not Found any Item";
		
		try (Connection conn = DBUtill.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select purchase_date, seller_name, buyer_name, count(*) as Number_Of_Product from details");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Date purchase = rs.getDate("purchase_date");
				String seller = rs.getString("seller_name");
				String buyer = rs.getString("buyer_name");
				int numberOfProduct = rs.getInt("number_of_product");
				
				message = buyer+" has purchased "+numberOfProduct+" product from "+seller+" on "+purchase;
				
			}
			
		} catch (SQLException e) {
			
			e.getMessage();
			
		}
		
		return message;
		
	}

}
