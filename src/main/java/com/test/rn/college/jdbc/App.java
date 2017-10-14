package com.test.rn.college.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC example
 * 1. Get connection
 * 2. Create statement (Prepared statment)
 * 3. set parameter 
 * 4. execute the statement
 * 
 */
public class App {
	public static void main(String[] args) {
		App a = new App();
		Emp emp = new Emp(3, "Raj", "20-12-1992", 20000.0);
		Connection con = null;
		try {
			con = a.getConnection();
			//a.insertEmp(emp, con);
			a.getAllEmp(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/spring-jdbc", "root", "root");
		return con;
	}

	public void insertEmp(Emp emp, Connection con) throws Exception {
		String sql = "insert into emp (emp_no, emp_name, sal, dob) values(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, emp.getEmpNo());
		pstmt.setString(2, emp.getEmpName());
		pstmt.setDouble(3, emp.getSalary());
		pstmt.setString(4, emp.getDob());
		pstmt.execute();
		System.out.println("Inserted successfully");
	}
	
	public void getAllEmp(Connection con) throws Exception {
		String sql = "select * from emp";
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			System.out.println(rs.getInt("emp_no"));
			System.out.println(rs.getString("emp_name"));
			System.out.println(rs.getDouble("sal"));
			System.out.println(rs.getString("dob"));
		}
	}
}
