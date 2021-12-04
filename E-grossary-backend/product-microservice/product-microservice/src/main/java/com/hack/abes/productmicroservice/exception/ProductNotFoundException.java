package com.hack.abes.productmicroservice.exception;

public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(Long productId) {
        super(String.format("product with id '%s' is not found", productId));
    }

}
