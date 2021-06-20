package com.daniel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.daniel.model.Item;
import com.daniel.util.DbUtil;

public class ItemDao {

	private Connection connection;

	public ItemDao() {
		connection = DbUtil.getConnection();
	}

	public void addItem(Item item) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into item_info(name, author, price, qty, memo) values (?, ?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, item.getName());
			preparedStatement.setString(2, item.getAuthor());
			preparedStatement.setInt(3, item.getPrice());
			preparedStatement.setInt(4, item.getQty());
			preparedStatement.setString(5, item.getMemo());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteItem(int itemId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from item_info where itemid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, itemId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateItem(Item item) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update item_info set name=?, author=?, price=?, qty=?, memo=?" +
							"where itemid=?");
			// Parameters start with 1
			preparedStatement.setString(1, item.getName());
			preparedStatement.setString(2, item.getAuthor());
			preparedStatement.setInt(3, item.getPrice());
			preparedStatement.setInt(4, item.getQty());
			preparedStatement.setString(5, item.getMemo());
			preparedStatement.setInt(6, item.getItemid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<Item>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from item_info");
			while (rs.next()) {
				Item item = new Item();
				item.setItemid(rs.getInt("itemid"));
				item.setName(rs.getString("name"));
				item.setAuthor(rs.getString("author"));
				item.setPrice(rs.getInt("price"));
				item.setQty(rs.getInt("qty"));
				item.setMemo(rs.getString("memo"));
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return items;
	}
	
	public Item getItemByItemId(int itemId) {
		Item item = new Item();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from item_info where itemid=?");
			preparedStatement.setInt(1, itemId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				item.setItemid(rs.getInt("itemid"));
				item.setName(rs.getString("name"));
				item.setAuthor(rs.getString("author"));
				item.setPrice(rs.getInt("price"));
				item.setQty(rs.getInt("qty"));
				item.setMemo(rs.getString("memo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return item;
	}
	
	public void decreaseQtybyItemId(String[] ids) {
		for(int i=0;i<ids.length;i++) {
			try {
				PreparedStatement preparedStatement = connection.
						prepareStatement("update item_info SET qty = qty - 1 WHERE itemid=?");
				preparedStatement.setInt(1, Integer.parseInt(ids[i]));
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
