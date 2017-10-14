package com.test.rn.college.jdbc;

public class Emp {

	private Integer empNo;
	private String empName;
	private String dob;
	private Double salary;
	public Emp(){
		
	}
	
	public Emp(Integer empNo, String empName, String dob, Double salary) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.dob = dob;
		this.salary = salary;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
