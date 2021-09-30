package com.hack.abes.productmicroservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hack.abes.productmicroservice.model.Shop;
import com.hack.abes.productmicroservice.repository.ShopRepository;
import com.hack.abes.productmicroservice.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopRepository shopRepository;

	@Override
	public Shop registerShop(Shop shop) {
		
		
		return this.shopRepository.save(shop);
	}

	@Override
	public List<Shop> getAllShops() {
		
		return this.shopRepository.findAll();
	}

	@Override
	public Shop getShopDetail(Long id) {
		Shop theShop=this.shopRepository.findById(id).get();
		return theShop;
	}

}
