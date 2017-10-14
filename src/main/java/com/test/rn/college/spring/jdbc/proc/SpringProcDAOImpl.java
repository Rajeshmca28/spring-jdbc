package com.test.rn.college.spring.jdbc.proc;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.test.rn.college.jdbc.Emp;

public class SpringProcDAOImpl implements EmpDAO {
	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcCall = new SimpleJdbcCall(dataSource)
				.withProcedureName("get_emp_by_no");
	}

	public Emp getEmp(Integer empNo) {
		SqlParameterSource in = new MapSqlParameterSource().addValue("emp_n",
				empNo);
		Map<String, Object> out = jdbcCall.execute(in);
		Emp emp = new Emp();
		emp.setEmpName((String)out.get("e_name"));
		emp.setSalary((Double) out.get("salary"));
		emp.setDob((String) out.get("date_dob"));
		
		return emp;
	}
}
