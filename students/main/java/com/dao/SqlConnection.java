package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Statement;

public class SqlConnection {

	public static Connection getConnection() throws Exception {

		try {

			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/students";
			String username = "root";
			String password = "root";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("connected");
			return con;

		} catch (Exception e) {

			System.out.println("connection failed");

		}
		return null;

	}

	public static void main(String[] args) throws Exception {

		try {

			Connection con = getConnection();
			// PreparedStatement create = con.prepareStatement("SELECT * FROM INFORMATION");

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM INFORMATION");

			System.out.println("im here");

			while (rs.next()) {
				System.out.println(rs.getString("First_Name"));
				System.out.println(rs.getString("Last_Name"));
			}

			con.close();

		} catch (Exception E) {

		}

	}

}
