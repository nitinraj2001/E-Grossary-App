package com.hack.abes.egrossaryapp.service;

import org.springframework.stereotype.Service;

import com.hack.abes.egrossaryapp.model.Payment;

@Service
public interface PaymentService {
	
	public Payment doPayment(Payment payment);

}
