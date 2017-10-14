package com.test.rn.college.spring.simplejdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.test.rn.college.jdbc.Emp;

public class JdbcEmpDAOImpl implements EmpDAO {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Emp emp) {

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			String sql = "insert into emp (emp_no, emp_name, sal, dob) values(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpNo());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setDouble(3, emp.getSalary());
			pstmt.setString(4, emp.getDob());
			pstmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public Emp findByEmpNo(int empNo) {

		String sql = "SELECT * FROM emp WHERE emp_no = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, empNo);
			Emp emp = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				emp = new Emp(rs.getInt("emp_no"), rs.getString("emp_name"),
						rs.getString("dob"), rs.getDouble("sal"));
			}
			rs.close();
			ps.close();
			return emp;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public List<Emp> findAllEmp() {

		String sql = "SELECT * FROM emp";
		List<Emp> empList = new ArrayList<Emp>();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			Emp emp = null;
			rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Emp(rs.getInt("emp_no"), rs.getString("emp_name"),
						rs.getString("dob"), rs.getDouble("sal"));
				empList.add(emp);
			}
			return empList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}