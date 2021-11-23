package com.hack.abes.productmicroservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hack.abes.productmicroservice.model.ProductCategory;
import com.hack.abes.productmicroservice.response.ProductCategoryResponse;

@Service
public interface ProductCategoryService {
	
	public ProductCategoryResponse registerProductCategory(ProductCategory category );
	
	public List<ProductCategory> getAllProductCategoryInShop(Long shopId);
	
	public ProductCategory getProductCategoryDetails(Long categoryId);

}
