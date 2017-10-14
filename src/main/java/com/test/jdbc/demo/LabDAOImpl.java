package com.test.jdbc.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class LabDAOImpl implements LabDAO {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Liberary lab) {

		String sql = "insert into liberary (lab_id, l_name, book_id, book_name,issue_date,deposit_date) values(?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, lab.getLabId());
			pstmt.setString(2, lab.getlName());
			pstmt.setString(3, lab.getBookId());
			pstmt.setString(4, lab.getBookName());
			pstmt.setString(5, lab.getIssueDate());
			pstmt.setString(6, lab.getDepositDate());
			pstmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Liberary findByLabId(int labId) {

		String sql = "SELECT * FROM liberary WHERE lab_id = ?";


		try (Connection conn = dataSource.getConnection();PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setInt(1, labId);
			ResultSet rs = ps.executeQuery();
			Liberary lab = null;
			if (rs.next()) {
				lab = new Liberary(rs.getInt("lab_id"), rs.getString("l_name"),
						rs.getString("book_id"), rs.getString("book_name"),rs.getString("issue_date"),rs.getString("deposit_date"));
			}
			return lab;
		} catch (SQLException e) {
			throw new RuntimeException(e);
				}
	}

	public List<Liberary> findAllLiberary() {

		String sql = "SELECT * FROM liberary";
		try (Connection conn = dataSource.getConnection();PreparedStatement ps = conn.prepareStatement(sql);ResultSet rs = ps.executeQuery();)
{		List<Liberary> labList = new ArrayList<Liberary>();

			while (rs.next()) {
				Liberary lab = new Liberary(rs.getInt("lab_id"), rs.getString("l_name"),
						rs.getString("book_id"), rs.getString("book_name"),rs.getString("issue_date"),rs.getString("deposit_date"));
				labList.add(lab);
			}
			return labList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
					}
		}
	}

