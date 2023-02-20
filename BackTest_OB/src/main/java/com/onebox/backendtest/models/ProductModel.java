package com.onebox.backendtest.models;

import java.math.BigDecimal;

public class ProductModel {
	public static int lastId = 0;
	
	private Integer id;
	private String description;
	private BigDecimal amount;
	
	public ProductModel(String description, BigDecimal amount) {
		id = lastId++;
		
		this.description = description;
		this.amount = amount;
	}
	
}
