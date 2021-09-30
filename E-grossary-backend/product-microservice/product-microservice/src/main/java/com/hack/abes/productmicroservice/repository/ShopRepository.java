package com.hack.abes.productmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hack.abes.productmicroservice.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
	
	public Shop findByName(String name);

}
