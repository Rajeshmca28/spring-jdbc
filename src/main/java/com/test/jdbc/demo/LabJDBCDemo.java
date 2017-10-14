package com.test.jdbc.demo;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class LabJDBCDemo {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		LabDAO labDAO = (LabDAO) context.getBean("labDAO");
		Liberary lab = new Liberary(11, "ssfddj", "bfh21","smmes","23-2-2017","12-5-2017");
		labDAO.insert(lab);

		lab = labDAO.findByLabId(1);
		System.out.println(lab);

		List<Liberary> labList = labDAO.findAllLiberary();
		display(labList);
		context.close();
	}

	public static void display(List<Liberary> labList) {
		Iterator<Liberary> labIterator = labList.iterator();
		while (labIterator.hasNext()) {
			Liberary lab = labIterator.next();
			System.out.println(" Lab id : " + lab.getLabId() + " Lab Name : " + lab.getlName()+" Book id : " + lab.getBookId()
					+"Book Name  " + lab.getBookName()+"Isuue Date  " + lab.getIssueDate()+"DepositDate  : " + lab.getDepositDate()					);
		}
	}
}
