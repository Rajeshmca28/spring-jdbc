package com.test.rn.college.spring.simplejdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.test.rn.college.jdbc.Emp;

public class SimpleJdbcInsertEmpDAOImpl implements EmpDAO {
	private DataSource dataSource;
	private SimpleJdbcInsert insertCustomer;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.insertCustomer = new SimpleJdbcInsert(dataSource).withTableName("emp");
	}

	public void insert(Emp emp) {
		Map<String, Object> params = new HashMap<String, Object>(3);
		params.put("emp_no", emp.getEmpNo());
		params.put("emp_name", emp.getEmpName());
		params.put("sal", emp.getSalary());
		params.put("dob", emp.getDob());
		insertCustomer.execute(params);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public Emp findByEmpNo(int empNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Emp> findAllEmp() {
		// TODO Auto-generated method stub
		return null;
	}

}