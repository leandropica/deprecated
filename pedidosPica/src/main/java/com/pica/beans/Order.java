package com.pica.beans;


public class Order {

	private String user;

	private Product product;

	private Integer cant;
	
	private Double ammount; 

	public Order() {}
	
	public Order(String user, Product product, Integer cant) {
		super();
		this.user = user;
		this.product = product;
		this.cant = cant;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getCant() {
		return cant;
	}

	public void setCant(Integer cant) {
		this.cant = cant;
	}

	public Double getAmmount() {
		return ammount;
	}

	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}
	
	
}