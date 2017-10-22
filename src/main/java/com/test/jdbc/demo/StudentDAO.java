package com.test.jdbc.demo;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.test.rn.college.jdbc.Emp;

public class StudentDAO {
public static void main(String[] args){
	StudentDAO studDAO=new StudentDAO();
	Student stud=new Student("s12","Rajesh","10/12/2017","1992","delhi");
	Connection conn=null;
	try{
	 conn=studDAO.getConnection();
	
	 studDAO.getAllStudent(conn);
		
	} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}
public Connection getConnection() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/spring-jdbc", "root", "root");
	return conn;
}

public void insertEmp(Student stud, Connection conn) throws Exception {
	String sql = "insert into emp (studId, name, dob,cource,addr) values(?,?,?,?,?)";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, stud.getStudId());
	pstmt.setString(2, stud.getName());
	pstmt.setString(3, stud.getDob());
	pstmt.setString(4, stud.getCource());
	pstmt.setString(5, stud.getAddr());
	pstmt.execute();
	System.out.println("Inserted successfully");
}


public void getAllStudent(Connection con) throws Exception {
	String sql = "select * from student";
	Statement stmt = con.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	while(rs.next()){
		System.out.println(rs.getString("stud_id"));
		System.out.println(rs.getString("name"));
		System.out.println(rs.getString("dob"));
		System.out.println(rs.getString("cource"));
		System.out.println(rs.getString("addr"));

	}
}

	}

