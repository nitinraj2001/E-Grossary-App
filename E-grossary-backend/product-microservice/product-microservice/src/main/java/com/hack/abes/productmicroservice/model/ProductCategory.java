package com.hack.abes.productmicroservice.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product_category")
public class ProductCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String categoryName;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="category")
	private Set<Product> products;
	
	private Long shopId;
	
	private String description;
	
	//image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
	@Column(name = "picByte")
	private byte[] picByte;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	
	public ProductCategory() {
		super();
	}

	public ProductCategory(String categoryName, Set<Product> products, Long shopId, String description,
			byte[] picByte) {
		super();
		this.categoryName = categoryName;
		this.products = products;
		this.shopId = shopId;
		this.description = description;
		this.picByte = picByte;
	}
	
	
	
	
	
	

}
