package com.mahendra.jdbcdemo;

import java.sql.*;
import java.util.Date;

public class Main {

	private static final String MYSQL_URL="jdbc:mysql://sample-db.arfxbmc0ggakbact.centralindia.azurecontainer.io:3306";
	private static final String USER="mahendra";
	private static final String PASSWORD = "pass@1234";
	private static final String FETCH_EMP 
			= "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date "
			+ "FROM hr.employees "
			+ "WHERE emp_no <= 10100;" ;
			
	
	public static void main(String[] args) {
		
		Date dt = new Date();
		System.out.println(dt);
		System.out.println(dt.getTime());
		
		Connection con = null;
		//Stage 1: Load the JDBC Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException ex) {
			System.out.println("JDBC Driver cannot be found/load !");
			return;
		}

		//Stage 2: Connect to Database
		try {
			con = DriverManager.getConnection(MYSQL_URL, USER, PASSWORD);
			System.out.println("Connected to Database");
		}catch(SQLException ex) {
			System.err.println("Unable to connect database ");
			System.err.println(ex.getMessage());
			return;
		}
		
		//Stage 3: Execute "SQL" Query and get data !
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(FETCH_EMP);
			System.out.println("Emp No   | First Name   | Last Name     ");
			while(rs.next()) {
				System.out.printf("\n%8d | %-12s | %-12s ",
						rs.getInt("emp_no"),
						rs.getString("first_name"),
						rs.getString("last_name")
				);
			}
			
		}catch(SQLException ex) {
			System.out.println("Unable to fetch data "+ ex.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
