package com.ProductDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

	Connection conn = null;
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	public ProductDB() {
		try {

			Class.forName(JDBC_DRIVER);
			// Specify the database name in the connection URL
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "shubham");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Close the connection in a finally block
	public void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void save(Product p) {
		// Define the SQL query with placeholders for the values
		String query = "INSERT INTO product (id,name, type, place, warranty) VALUES (?,?, ?, ?, ?)";
		try {
			// Create a PreparedStatement for executing the query
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			// Set the values for the placeholders
			preparedStatement.setInt(1, p.getId());
			preparedStatement.setString(2, p.getName());
			preparedStatement.setString(3, p.getType());
			preparedStatement.setString(4, p.getPlace());
			preparedStatement.setInt(5, p.getWarranty());
			// Execute the query
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Product> getAll() {
	    String query = "SELECT * FROM product";
	    List<Product> products = new ArrayList<>();

	    try {
	        PreparedStatement preparedStatement = conn.prepareStatement(query);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            // Create a new Product object for each row
	            Product product = new Product();
	            product.setId(rs.getInt("id"));
	            product.setName(rs.getString("name"));
	            product.setType(rs.getString("type"));
	            product.setPlace(rs.getString("place"));
	            product.setWarranty(rs.getInt("warranty"));

	            // Add the Product object to the list
	            products.add(product);
	        }

	        return products;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    // Return an empty list if an exception occurs
	    return products;
	}

}
