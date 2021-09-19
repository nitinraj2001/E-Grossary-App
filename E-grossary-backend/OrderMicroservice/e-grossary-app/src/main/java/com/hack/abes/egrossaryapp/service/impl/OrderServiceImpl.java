package com.hack.abes.egrossaryapp.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.hack.abes.egrossaryapp.model.Order;
import com.hack.abes.egrossaryapp.repository.OrderRepository;
import com.hack.abes.egrossaryapp.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository theOrderRepository;

	@Override
	public Order bookOrder(Order order) {
		
		order.setDate(new Date());
		
		Order theorder=this.theOrderRepository.save(order);
		
		return theorder;
	}

}
