package com.hack.abes.egrossaryapp.service;

import org.springframework.stereotype.Service;

import com.hack.abes.egrossaryapp.model.Order;

@Service
public interface OrderService {
	
	public Order bookOrder(Order order);

}
