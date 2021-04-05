package com.ecommerce.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.service.OrderProducerService;

@RestController
@RequestMapping(value = "/kafka")
public class OrderProducerController 
{
	@Autowired
	private OrderProducerService orderProducerService;
	
	@PostMapping(value="/createOrder")
	public void createOrderToKafkaTopic(@RequestBody Order order)
	{
		orderProducerService.saveCreateorUpdateOrder(order);
	}
	
	@PutMapping(value="/updateOrder")
	public void updateOrderToKafkaTopic(@RequestBody Order order)
	{
		orderProducerService.saveCreateorUpdateOrder(order);
	}
}	
