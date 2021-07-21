package com.company.products.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Prueba Tecnica . Price
 * @author lpicareli
 */
@Entity
@Table(name = "PRICES")
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	//@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "BRAND_ID")
    //private Brands brands;
	@Column(name = "BRAND_ID", nullable = false, unique = false)
	private Long brandId;

	@Column(name = "START_DATE", nullable = false, unique = false)
	private Date startDate;

	@Column(name = "END_DATE", nullable = false, unique = false)
	private Date endDate;

	@Column(name = "PRICE_LIST", nullable = false, unique = false)
	private Long priceList;

	@Column(name = "PRODUCT_ID", nullable = false, unique = false)
	private Long productId;

	@JsonIgnore
	@Column(name = "PRIORITY", nullable = false, unique = false)
	private int priority;

	@Column(name = "PRICE", nullable = false, unique = false)
	private Double price;

	@JsonIgnore
	@Column(name = "CURR", nullable = false, unique = false)
	private String curr;

	protected Price() {
	}

	public Price(Long id, Long brandId, Date startDate, Date endDate, Long priceList, Long productId, int priority,
			Double price, String curr) {
		super();
		this.id = id;
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.productId = productId;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getPriceList() {
		return priceList;
	}

	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

}