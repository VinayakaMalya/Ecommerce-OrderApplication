package com.ecommerce.order.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.service.OrderService;

@RestController
public class OrderController
{
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order/{orderId}")
	public Optional<Order> findOrderById(@PathVariable("orderId") long orderId)
	{
		return orderService.findOrderById(orderId);
	}
	
	@PostMapping("/order")
	public Order createOrder(@RequestBody Order order)
	{
		return orderService.createOrder(order);
	}
	
	@PutMapping("/order/{orderId}")
	public Order cancelOrder(@PathVariable("orderId") long orderId)
	{
		return orderService.cancelOrder(orderId);
		
	}
}
