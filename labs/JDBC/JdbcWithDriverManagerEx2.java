package com.jdbctraining.core.java;
//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcWithDriverManagerEx2 {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/jdbctraining";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "pass@word1";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection Established: " +conn);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			//Insert with statement
	//		String insertQuery = "INSERT INTO employee (name, age, designation, department, country) VALUES ('Dusyanta', 27, 'Tester', 'IT', 'Uganda')";			
	//		int insertCount = stmt.executeUpdate(insertQuery);
	//		System.out.println("Employee Inserted " +insertCount);
			
			//Insertion with Prepared Statement
			String insertQueryForPreparestmt = "INSERT INTO employee (name, age, designation, department, country) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insertQueryForPreparestmt);
			pstmt.setString(1,"Goku");
			pstmt.setInt(2,30);
			pstmt.setString(3,"Sr.Developer");
			pstmt.setString(4,"IT");
			pstmt.setString(5,"India");
			int insertCount = pstmt.executeUpdate();
			System.out.println(insertCount + "Employees Updated ");
			
			
	//		String selectQuery = "SELECT * FROM employee";
	//		ResultSet rs = stmt.executeQuery(selectQuery);
				
			String sql1, sql2;
			sql1 = "SELECT id, name, age, designation FROM employee";
//			 sql1 = "SELECT id, name, age FROM employee WHERE age >= 35 AND department='Admin' ORDER BY name";
			sql2 = "UPDATE employee SET age=? WHERE id=?";

		    pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, 22);
			pstmt.setInt(2, 3);

			//boolean status = stmt.execute(sql2);
			boolean status = pstmt.execute();
		System.out.println("Update status: " + status);
			ResultSet rs = stmt.executeQuery(sql1);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String name = rs.getString("name");
				String designation = rs.getString("designation");

				// Display values
				System.out.print("ID: " + id);
				System.out.print(", Age: " + age);
				System.out.print(", Name: " + name);
				System.out.print(", Designation: " + designation);

				System.out.println();
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}// end main
}// end FirstExample