package com.hack.abes.egrossaryapp.service.impl;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.hack.abes.egrossaryapp.model.Payment;

import com.hack.abes.egrossaryapp.repository.PaymentRepository;

import com.hack.abes.egrossaryapp.service.PaymentService;


public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment doPayment(Payment payment) {
		payment.setTransactionId(UUID.randomUUID().toString());
		return this.paymentRepository.save(payment);
	}
	
	public String paymentProcessing() {
		return new Random().nextBoolean()?"payment is successfully done":"payment not able to done";
	}

}
