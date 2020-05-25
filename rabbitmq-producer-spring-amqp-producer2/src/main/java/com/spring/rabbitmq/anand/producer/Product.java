package com.spring.rabbitmq.anand.producer;

import java.io.Serializable;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int productId;
	private String name;
	private int quantity;
	public Product() {}
	public Product(int oroductId, String name, int quantity) {
		super();
		this.productId = oroductId;
		this.name = name;
		this.quantity = quantity;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [oroductId=" + productId + ", name=" + name + ", quantity=" + quantity + "]";
	}
	

}
