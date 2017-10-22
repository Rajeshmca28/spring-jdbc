package com.test.jdbc.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class ProductDAOSupportImpl extends JdbcDaoSupport implements ProductDAO {
	
	public void insert(Product product) {
	String sql = "insert into product (product_id, product_name, cat_id,type, details) values(?,?,?,?,?)";
		Object[] params = new Object[] { product.getProductId(), product.getProductName(),
				product.getCatId(), product.getType(),product.getDetails() };
		getJdbcTemplate().update(sql, params);
	}
	/*public void delete(Product product){
		String sql="delete  product where product_id=?";
		Object[] params=new Object[] {product.getProductId(),product.getProductName(),product.getType(),product.getCatId(),product.getDetails()};
		getJdbcTemplate().delete(sql,params);
		
	}*/
	public void update(Product product) {
		String sql = "delete from product   where product_id = ?";

		Object[] params = new Object[] {product.getProductId(),product.getProductName(), product.getCatId(),
				product.getType(),product.getDetails() };
		getJdbcTemplate().update(sql, params);
	}

	public Product findByProductId(int productId) {
		String sql = "SELECT * FROM product WHERE product_id = ?";
		Object [] params = new Object[] { productId};
		Product product =getJdbcTemplate().queryForObject(sql, new RowMapper<Product>(){
	
public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				return new Product(rs.getInt("product_id"), rs.getString("product_name"),
						rs.getString("cat_id"), rs.getString("type"),rs.getString("details"));
		}},params);
		return product;
	}

	public List<Map<String,Object>> findAllProduct() {
		String sql = "SELECT * FROM product ";
		List<Map<String,Object>> prodList =getJdbcTemplate().queryForList(sql);
		return prodList;
	}

}