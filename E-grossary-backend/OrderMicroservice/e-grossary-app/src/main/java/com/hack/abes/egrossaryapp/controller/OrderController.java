package com.hack.abes.egrossaryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hack.abes.egrossaryapp.model.Order;
import com.hack.abes.egrossaryapp.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService theOrderService;
	
	@PostMapping("/bookOrder")
	public Order bookOrder(@RequestBody Order theOrder) {
		return this.theOrderService.bookOrder(theOrder);
	}
	

}
