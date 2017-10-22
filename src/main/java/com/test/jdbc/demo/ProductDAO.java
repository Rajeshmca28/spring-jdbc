package com.test.jdbc.demo;

import java.util.List;
import java.util.Map;
public interface ProductDAO {

	public void insert(Product product);

	public Product findByProductId(int productId);

	public List<Map<String,Object>> findAllProduct() ;

	public void update(Product product);

	//public void delete(Product product);

}
