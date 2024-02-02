package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.dto.Order;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentService {

//	private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);
	
	public void processPayment(Order order) throws InterruptedException {

		log.info("initiate payment for order id " + order.getProductId());

		//call actual payment gatway
		Thread.sleep(2000L);
		
		log.info("completed payment for order id " + order.getProductId());
		
	}

}
