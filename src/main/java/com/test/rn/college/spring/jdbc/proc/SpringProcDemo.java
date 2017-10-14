package com.test.rn.college.spring.jdbc.proc;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.rn.college.jdbc.Emp;

public class SpringProcDemo {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config-proc.xml");
		EmpDAO empDAO = (EmpDAO) context.getBean("empDAO");
		Emp emp = empDAO.getEmp(9);
		System.out.println(emp.getEmpName());
		System.out.println(emp.getSalary());
		System.out.println(emp.getDob());
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
