package com.hack.abes.productmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hack.abes.productmicroservice.model.ProductCategory;

@Repository
public interface ProductCategoryRepository  extends JpaRepository<ProductCategory, Long> {

	public List<ProductCategory> findAllByshopId(Long shopId);
}