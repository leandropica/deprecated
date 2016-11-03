package com.pica.beans;


public class Product {

	//@NotEmpty
	private String id;
	
	private String title;
	
	private String description;
	
	private String image;
	
	private Double value;
    
	public Product() {}
	
	public Product(String id) {
		this.id = id;
	}
	
	public Product(String id, String title, String description, String image, Double value) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.image = image;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}