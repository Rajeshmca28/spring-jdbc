package com.test.rn.college.spring.jdbc;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.rn.college.jdbc.Emp;

public class SpringJDBCDemo {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		EmpDAO empDAO = (EmpDAO) context.getBean("empDAO");
		// Emp emp = new Emp("Rakesh",28L);
		Emp emp = new Emp(6, "Raj", "20-12-1992", 20000.0);
		empDAO.insert(emp);

		emp = empDAO.findByEmpNo(1);
		System.out.println(emp);

		List<Emp> empList = empDAO.findAllEmp();
		display(empList);
		context.close();
	}

	public static void display(List<Emp> empList) {
		Iterator<Emp> empIterator = empList.iterator();
		while (empIterator.hasNext()) {
			Emp emp = empIterator.next();
			System.out.println(" Emp id : " + emp.getEmpNo() + " Name "
					+ emp.getEmpName() + " Salary " + emp.getSalary());
		}
	}
}
