package com.test.rn.college.spring.jdbc.template;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.rn.college.jdbc.Emp;


public class SpringJDBCTemplateDemo {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config-template.xml");
		EmpDAO empDAO = (EmpDAO) context.getBean("empDAO");
		Emp emp = new Emp(9, "Raj-update", "20-12-1992", 30000.0);
		//empDAO.insert(emp);
		empDAO.update(emp);
	    emp =empDAO.findByEmpNo(7);
		 List<Map<String,Object>> list =empDAO.findAllEmp();
		display(list);
		System.out.println(emp.getEmpName());
		context.close();
	}
	
	public static void display(List<Map<String,Object>> empList){
		Iterator<Map<String,Object>> empIterator = empList.iterator();
		while(empIterator.hasNext()){
			Map<String,Object> empMap = empIterator.next();
			System.out.println(" Emp id : " + empMap.get("emp_no") + " Name "
					+ empMap.get("emp_name") + " Salary " + empMap.get("sal"));
		
		}
	}
}
