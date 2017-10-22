package com.test.rn.college.spring.jdbc.template;

import java.util.List;
import java.util.Map;

import com.test.rn.college.jdbc.Emp;

public interface EmpDAO {

	public void insert(Emp emp);
	public void update(Emp emp) ;
	public Emp findByEmpNo(int empNo);

	public List<Map<String,Object>> findAllEmp() ;

}
