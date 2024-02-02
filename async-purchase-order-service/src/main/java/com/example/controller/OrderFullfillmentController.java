package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Order;
import com.example.service.OrderFullfillmenntService;

@RestController
public class OrderFullfillmentController {

	@Autowired
	private OrderFullfillmenntService orderFullfillmenntService;
	
	@PostMapping("/order")
	public ResponseEntity<Order> processOrder(@RequestBody Order order) throws InterruptedException{
		orderFullfillmenntService.processOrder(order);
		orderFullfillmenntService.notifyUser(order);
		orderFullfillmenntService.assignVendor(order);
		orderFullfillmenntService.packaging(order);
		orderFullfillmenntService.assignDeliveryPartner(order);
		orderFullfillmenntService.assignTrailerAndDispatch(order);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
}
