package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.dto.Cart;

public class CartDAO {

	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbc_prc";
	String username = "root";
	String password = "root";
	Connection connection = null;

	public String insert(Cart c) {
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			String i_query = "INSERT INTO CART VALUES(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(i_query);
			preparedStatement.setInt(1, c.getId());
			preparedStatement.setString(2, c.getEmail());
			preparedStatement.setString(3, c.getPassword());
			preparedStatement.setString(4, c.getUsername());
			preparedStatement.setString(5, c.getAddress());
			int row = preparedStatement.executeUpdate();
			if (row == 1) {
				return "SAVED!";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "NOT SAVED!";
	}

	public String update(Cart c) {
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			String u_query = "UPDATE CART SET email = ?, password = ?, username = ?, address=? WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(u_query);
			preparedStatement.setString(1, c.getEmail());
			preparedStatement.setString(2, c.getPassword());
			preparedStatement.setString(3, c.getUsername());
			preparedStatement.setString(4, c.getAddress());
			preparedStatement.setInt(5, c.getId());
			int row = preparedStatement.executeUpdate();
			if (row == 1) {
				return "UPDATED!";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "NOT UPDATED!";
	}

	public String delete(int id) {
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			String d_query = "DELETE FROM CART WHERE ID=?";
			PreparedStatement preparedStatement = connection.prepareStatement(d_query);
			preparedStatement.setInt(1, id);
			int row = preparedStatement.executeUpdate();
			if (row == 1) {
				return "DELETED!";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return "NOT DELETED!";
	}

	public Cart get(int id) {
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			String g_query = "SELECT * FROM CART WHERE ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(g_query);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			Cart c = new Cart();
			while (rs.next()) {
				c.setId(rs.getInt(1));
				c.setEmail(rs.getString(2));
				c.setPassword(rs.getString(3));
				c.setUsername(rs.getString(4));
				c.setAddress(rs.getString(5));
			}
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return null;
	}

	public List<Cart> getAll() {
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			String all_query = "SELECT * FROM CART";
			PreparedStatement preparedStatement = connection.prepareStatement(all_query);
			ResultSet rs = preparedStatement.executeQuery();
			List<Cart> list = new ArrayList();
			while (rs.next()) {
				Cart c = new Cart();
				c.setId(rs.getInt(1));
				c.setEmail(rs.getString(2));
				c.setPassword(rs.getString(3));
				c.setUsername(rs.getString(4));
				c.setAddress(rs.getString(5));
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return null;
	}
}