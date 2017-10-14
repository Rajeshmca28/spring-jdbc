package com.test.rn.college.spring.jdbc.template;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.test.rn.college.jdbc.Emp;

public class TemplateEmpDAOImpl implements EmpDAO {
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insert(Emp emp) {
		String sql = "insert into emp (emp_no, emp_name, sal, dob) values(?,?,?,?)";
		Object[] params = new Object[] { emp.getEmpNo(), emp.getEmpName(),
				emp.getSalary(), emp.getDob() };
		jdbcTemplate.update(sql, params);
	}
	
	public void update(Emp emp) {
		String sql = "update emp  set emp_name =?, sal=?, dob = ?  where emp_no = ?";
		Object[] params = new Object[] { emp.getEmpName(), emp.getSalary(),
				 emp.getDob(),emp.getEmpNo() };
		jdbcTemplate.update(sql, params);
	}

	@Override
	public Emp findByEmpNo(int empNo) {
		//write a query so that it should return only single row
		String sql = "SELECT * FROM emp WHERE emp_no = ?";
		Object [] params = new Object[] { empNo};
		Emp employee =jdbcTemplate.queryForObject(sql, new RowMapper<Emp>(){
			@Override
		public Emp mapRow(ResultSet rs, int arg1) throws SQLException {
				return new Emp(rs.getInt("emp_no"), rs.getString("emp_name"),
						rs.getString("dob"), rs.getDouble("sal"));
		}},params);
		return employee;
	}

	@Override
	public List<Map<String,Object>> findAllEmp() {
		String sql = "SELECT * FROM emp ";
		//Object [] params = new Object[] { empNo};
		List<Map<String,Object>> employeeList =jdbcTemplate.queryForList(sql);
		return employeeList;
	}

}