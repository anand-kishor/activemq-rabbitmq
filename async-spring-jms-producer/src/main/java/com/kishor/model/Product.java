package com.kishor.model;

import java.io.Serializable;

public class Product implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int productId;
	private String name;
	private int quqntity;
	public Product()
	{
		
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuqntity() {
		return quqntity;
	}
	public void setQuqntity(int quqntity) {
		this.quqntity = quqntity;
	}
	public Product(int productId, String name, int quqntity) {
		
		this.productId = productId;
		this.name = name;
		this.quqntity = quqntity;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", quqntity=" + quqntity + "]";
	}

}
