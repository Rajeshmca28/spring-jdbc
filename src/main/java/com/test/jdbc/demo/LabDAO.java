package com.test.jdbc.demo;

import java.util.List;


public interface LabDAO {

	public void insert(Liberary Liberary);

	public Liberary findByLabId(int labId);

	public List<Liberary> findAllLiberary();

}
