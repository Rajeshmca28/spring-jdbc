package com.test.jdbc.demo;

public class Product {
private int productId;
private String productName;
private String catId;
private String type;
private String details;
public Product(Integer productId,String productName,String catId,String type,String details){
	this.productId=productId;
	this.productName=productName;
	this.catId=catId;
	this.type=type;
	this.details=details;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getCatId() {
	return catId;
}
public void setCatId(String catId) {
	this.catId = catId;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}

}
