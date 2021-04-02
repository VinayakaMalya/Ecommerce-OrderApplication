package com.ecommerce.order.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService
{
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Optional<Order> findOrderById(long orderId)
	{
		return orderRepository.findById(orderId);
	}

	@Override
	public Order createOrder(Order order)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
