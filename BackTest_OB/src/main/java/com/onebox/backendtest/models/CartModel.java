package com.onebox.backendtest.models;

import java.util.LinkedList;

public class CartModel {
	public static int lastId = 0;
	
	private Integer id;
	private LinkedList<ProductModel> products;
	
	
	public CartModel() {
		id = lastId++;
	}

	public Integer getId() {
		return id;
	}

	public LinkedList<ProductModel> getProducts() {
		return products;
	}
	
}
