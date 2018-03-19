package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.resource.StudentResource;

public class StudentDao {

	List<StudentResource> student;

	public List<StudentResource> getAllStudents() {

		try {

			Connection con = getConnection();

			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery("SELECT First_Name, Last_Name FROM INFORMATION");

			System.out.println("im in ths here");

			// PreparedStatement create = con.prepareStatement("INSERT INTO INFORMATION
			// (FIRST_NAME, LAST_NAME) VALUES (?,?)");

			// create.setString(1, st.getStudentName());
			// create.setString(2, st.getLastName());

			while (rs.next()) {

				StudentResource sr = new StudentResource();
				sr.setFirstName(rs.getString("First Name"));
				sr.setLastName(rs.getString("Last_Name"));
				student.add(sr);
				System.out.println("im in while lloop");
			}

			// create.executeUpdate();

			System.out.println("im here");
			con.close();

		} catch (Exception E) {

		}

		return student;
	}

	public void addStudents(StudentResource st) {

		try {

			Connection con = getConnection();

			// Statement statement = con.createStatement();

			// ResultSet rs = statement.executeQuery("INSERT INTO STUDENTS VALUES (?,?)");

			PreparedStatement create = con
					.prepareStatement("INSERT INTO INFORMATION (FIRST_NAME, LAST_NAME) VALUES (?,?)");

			create.setString(1, st.getStudentName());
			create.setString(2, st.getLastName());

			/*
			 * while (rs.next()) { System.out.println(rs.getString("First_Name"));
			 * System.out.println(rs.getString("Last_Name")); }
			 */
			create.executeUpdate();

			System.out.println("im here");
			con.close();

		} catch (Exception E) {

		}

		// student.add(st);
	}

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

}
