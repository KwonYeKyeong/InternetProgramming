package com.daniel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.daniel.model.User;
import com.daniel.util.DbUtil;

public class UserDao {

	private Connection connection;

	public UserDao() {
		connection = DbUtil.getConnection();
	}

	public void addUser(User user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into user_info(id, pw, name, dob, address) values (?, ?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, user.getId());
			preparedStatement.setString(2, user.getPw());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setDate(4, new java.sql.Date(user.getDob().getTime()));
			preparedStatement.setString(5, user.getAddress());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int userId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from user_info where userid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(User user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update user_info set id=?, pw=?, name=?, dob=?, address=?" +
							"where userid=?");
			// Parameters start with 1
			preparedStatement.setString(1, user.getId());
			preparedStatement.setString(2, user.getPw());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setDate(4, new java.sql.Date(user.getDob().getTime()));
			preparedStatement.setString(5, user.getAddress());
			preparedStatement.setInt(6, user.getUserid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from user_info");
			while (rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setId(rs.getString("id"));
				user.setPw(rs.getString("pw"));
				user.setName(rs.getString("name"));
				user.setDob(rs.getDate("dob"));
				user.setAddress(rs.getString("address"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	public User getUserByUserId(int userId) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from user_info where userid=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setId(rs.getString("id"));
				user.setPw(rs.getString("pw"));
				user.setName(rs.getString("name"));
				user.setDob(rs.getDate("dob"));
				user.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	public User getUserById(String id) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from user_info where id=?");
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setId(rs.getString("id"));
				user.setPw(rs.getString("pw"));
				user.setName(rs.getString("name"));
				user.setDob(rs.getDate("dob"));
				user.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
}
