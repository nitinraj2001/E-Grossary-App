package com.hack.abes.productmicroservice.service.impl;

import java.util.List;

import com.hack.abes.productmicroservice.model.ProductCategory;
import com.hack.abes.productmicroservice.repository.ProductCategoryRepository;
import com.hack.abes.productmicroservice.response.ProductCategoryResponse;
import com.hack.abes.productmicroservice.service.ProductCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	
	@Autowired
	private ProductCategoryRepository categoryRepository;

	@Override
	public void registerProductCategory(ProductCategory category) {
	    this.categoryRepository.save(category);
	}

	@Override
	public List<ProductCategory> getAllProductCategoryInShop(Long shopId) {
		
		return this.categoryRepository.findAllByshopId(shopId);
	}

	@Override
	public ProductCategory getProductCategoryDetails(Long categoryId) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(categoryId).get();
	}

}
