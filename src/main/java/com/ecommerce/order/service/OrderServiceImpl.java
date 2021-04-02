package com.ecommerce.order.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.repository.OrderItemsRepository;
import com.ecommerce.order.repository.OrderPaymentsRepository;
import com.ecommerce.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService
{
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemsRepository orderItemsRepository;
	
	@Autowired
	private OrderPaymentsRepository orderPaymentsRepository;
	
	@Override
	public Optional<Order> findOrderById(long orderId)
	{
		return orderRepository.findById(orderId);
	}

	@Override
	public Order createOrder(Order order)
	{
		Order orderRes = orderRepository.save(order);
		if(orderRes!=null && order.getOrderItems()!=null)
		{	
			orderItemsRepository.save(order.getOrderItems());
			orderPaymentsRepository.save(order.getOrderPayments());
		}
		return orderRes;
	}

	@Override
	public Order cancelOrder(long orderId) 
	{
		Optional<Order> orderRes = orderRepository.findById(orderId);
		orderRes.filter(null)
		
		return orderRes.get();
	}

}
