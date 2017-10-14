package com.test.jdbc.demo;

public class Liberary {
private Integer labId;
private String lName;
private String bookId;
private String bookName;
private String issueDate;
private String depositDate;

public Liberary(Integer labId,String lName,String bookId,String bookName,String issueDate,String depositDate){
	super();
this.labId=labId;
this.lName=lName;
this.bookId=bookId;
this.bookName=bookName;
this.issueDate=issueDate;
this.depositDate=depositDate;

}

public Integer getLabId() {
	return labId;
}

public void setLabId(Integer labId) {
	this.labId = labId;
}

public String getlName() {
	return lName;
}

public void setlName(String lName) {
	this.lName = lName;
}

public String getBookId() {
	return bookId;
}

public void setBookId(String bookId) {
	this.bookId = bookId;
}

public String getBookName() {
	return bookName;
}

public void setBookName(String bookName) {
	this.bookName = bookName;
}

public String getIssueDate() {
	return issueDate;
}

public void setIssueDate(String issueDate) {
	this.issueDate = issueDate;
}

public String getDepositDate() {
	return depositDate;
}

public void setDepositDate(String depositDate) {
	this.depositDate = depositDate;
}
}
