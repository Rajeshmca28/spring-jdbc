package com.test.jdbc.demo;

public class Student {
private String studId;
private String name;
private String dob;
private String cource;
private String addr;

public Student(String studId,String name,String dob,String cource,String addr){
	super();
	this.studId=studId;
	this.name=name;
	this.dob=dob;		
	this.cource=cource;
	this.addr=addr;
	
}
public String getStudId() {
	return studId;
}
public void setStudId(String studId) {
	this.studId = studId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getCource() {
	return cource;
}
public void setCource(String cource) {
	this.cource = cource;
}
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
}
