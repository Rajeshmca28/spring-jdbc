package com.test.rn.college.spring.simplejdbc;

import java.util.List;

import com.test.rn.college.jdbc.Emp;

public interface EmpDAO {

	public void insert(Emp emp);

	public Emp findByEmpNo(int empNo);

	public List<Emp> findAllEmp();

}
