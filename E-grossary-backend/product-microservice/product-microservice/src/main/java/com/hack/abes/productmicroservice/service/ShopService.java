package com.hack.abes.productmicroservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hack.abes.productmicroservice.model.Shop;

@Service
public interface ShopService {

	public Shop  registerShop(Shop shop);
	
	public List<Shop> getAllShops();
	
	public Shop getShopDetail(Long id);
}
