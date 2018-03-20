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

	public List<StudentResource> getAllStudents() {

		try {
			List<StudentResource> student = new ArrayList<StudentResource>();
			Connection con = getConnection();

			Statement statement = con.createStatement();
			// PreparedStatement create = con.prepareStatement("SELECT First_Name, Last_Name
			// FROM INFORMATION");

			ResultSet rs = statement.executeQuery("select * FROM students.information");

			System.out.println("im in ths here" + rs.getFetchSize());

			// (FIRST_NAME, LAST_NAME) VALUES (?,?)");

			// create.setString(1, st.getStudentName());
			// create.setString(2, st.getLastName());

			while (rs.next()) {

				// student.add(new StudentResource(rs.getString("First_Name"),
				// rs.getString("Last_Name")));
				StudentResource sr = new StudentResource();
				sr.setFirst_Name(rs.getString("First_Name"));
				System.out.println(rs.getString("First_Name"));
				sr.setLast_Name(rs.getString("Last_Name"));
				student.add(sr);
				System.out.println("im in while lloop");
			}

			// create.executeUpdate();

			System.out.println("im here before close");
			con.close();
			return student;

		} catch (Exception E) {
			System.out.println(E.getMessage());
		}

		return null;
	}

	public void addStudents(StudentResource st) {

		try {

			Connection con = getConnection();

			// Statement statement = con.createStatement();

			// ResultSet rs = statement.executeQuery("INSERT INTO STUDENTS VALUES (?,?)");

			PreparedStatement create = con
					.prepareStatement("INSERT INTO INFORMATION (FIRST_NAME, LAST_NAME) VALUES (?,?)");

			create.setString(1, st.getFirst_Name());
			create.setString(2, st.getLast_Name());

			/*
			 * while (rs.next()) { System.out.println(rs.getString("First_Name"));
			 * System.out.println(rs.getString("Last_Name")); }
			 */
			create.executeUpdate();

			System.out.println("im here before closing");
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
