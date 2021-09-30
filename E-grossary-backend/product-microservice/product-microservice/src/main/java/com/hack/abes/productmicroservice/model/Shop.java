package com.hack.abes.productmicroservice.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shop {
	
	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", picByte="
				+ Arrays.toString(picByte) + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String email;
	
	private String address;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shop(String name, String email, String address, byte[] picByte) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.picByte = picByte;
	}
	
	

}
