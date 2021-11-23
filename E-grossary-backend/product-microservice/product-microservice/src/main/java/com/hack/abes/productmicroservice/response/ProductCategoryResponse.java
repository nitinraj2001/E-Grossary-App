package com.hack.abes.productmicroservice.response;

public class ProductCategoryResponse {
	
	private String success="product category is successfully added";
	
	private String failure="product category can't be added try again!";

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getFailure() {
		return failure;
	}

	public void setFailure(String failure) {
		this.failure = failure;
	}

	public ProductCategoryResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductCategoryResponse(String success, String failure) {
		super();
		this.success = success;
		this.failure = failure;
	}
	
	

}
