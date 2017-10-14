package com.test.rn.college.spring.jdbc.template.daosupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.test.rn.college.jdbc.Emp;

public class TemplateEmpDAOSupportImpl extends JdbcDaoSupport implements EmpDAO {
	
	public void insert(Emp emp) {
		//JdbcTemplate jdbcTemplate = getJdbcTemplate();
		String sql = "insert into emp (emp_no, emp_name, sal, dob) values(?,?,?,?)";
		Object[] params = new Object[] { emp.getEmpNo(), emp.getEmpName(),
				emp.getSalary(), emp.getDob() };
		//jdbcTemplate.update(sql, params);
		getJdbcTemplate().update(sql, params);
	}
	
	public void update(Emp emp) {
		String sql = "update emp  set emp_name =?, sal=?, dob = ?  where emp_no = ?";
		Object[] params = new Object[] { emp.getEmpName(), emp.getSalary(),
				 emp.getDob(),emp.getEmpNo() };
		getJdbcTemplate().update(sql, params);
	}

	@Override
	public Emp findByEmpNo(int empNo) {
		//write a query so that it should return only single row
		String sql = "SELECT * FROM emp WHERE emp_no = ?";
		Object [] params = new Object[] { empNo};
		Emp employee =getJdbcTemplate().queryForObject(sql, new RowMapper<Emp>(){
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
		List<Map<String,Object>> employeeList =getJdbcTemplate().queryForList(sql);
		return employeeList;
	}

}