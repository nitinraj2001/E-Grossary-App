package com.hack.abes.productmicroservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hack.abes.productmicroservice.exception.ProductNotFoundException;
import com.hack.abes.productmicroservice.model.Product;
import com.hack.abes.productmicroservice.repository.ProductRepository;
import com.hack.abes.productmicroservice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void registerProduct(Product product) {
		this.productRepository.save(product);

	}

	@Override
	public List<Product> getAllProducts() {
		
		return this.productRepository.findAll();
	}

	@Override
	public void deleteProduct(Long productId){
		Product product=this.productRepository.findById(productId).get();
	     if(product==null) {
	    	 try {
				throw new ProductNotFoundException(productId);
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     }
	     this.productRepository.deleteById(productId);

	}

	@Override
	public List<Product> getAllProductByShopId(Long shopId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductDetail(Long productId) {
	    Product product= this.productRepository.findById(productId).get();
	    if(product==null) {
	    	try {
				throw new ProductNotFoundException(productId);
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		return product;
	}

}
