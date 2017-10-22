package com.test.jdbc.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductDAOSupportDemo {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config-template-product-daosupport.xml");
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		Product product = new Product(109, "mobile", "m11", "telecome","j-7,samsung");
		productDAO.insert(product);
	  //  productDAO.delete(product);
		productDAO.update(product);
	    product =productDAO.findByProductId(1);
		 List<Map<String,Object>>prodList =productDAO.findAllProduct();
		display(prodList);
		System.out.println(product.getProductName());
		context.close();
	}
	
	public static void display(List<Map<String,Object>> productList){
		Iterator<Map<String,Object>> productIterator = productList.iterator();
		while(productIterator.hasNext()){
			Map<String,Object> productMap = productIterator.next();
			System.out.println(" product_id : " + productMap.get("product_name") + " Name "
					+ productMap.get("cat_id") + " Type " + productMap.get("type") +productMap.get("details"));
		
		}
	}
}
