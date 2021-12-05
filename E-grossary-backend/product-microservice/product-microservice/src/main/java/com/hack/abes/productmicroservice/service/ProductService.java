package com.hack.abes.productmicroservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hack.abes.productmicroservice.model.Product;

@Service
public interface ProductService {
	
	public void registerProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public void deleteProduct(Long productId);
	
	public Product getProductDetail(Long productId);
	
	public List<Product> getAllProductByShopId(Long shopId);

}
