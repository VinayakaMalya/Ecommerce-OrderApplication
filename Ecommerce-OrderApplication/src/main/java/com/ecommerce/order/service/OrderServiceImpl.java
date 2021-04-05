package com.ecommerce.order.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService
{
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
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
		logger.info(String.format("Order created -> %s",order));
		return orderRepository.save(order);
	}

	@Override
	public Order cancelOrder(Order order) 
	{
		Optional<Order> orderObj = orderRepository.findById(order.getOrderId());
		if(orderObj.isPresent())
			return orderRepository.save(order);
		else
			return null;
	}
	
	@KafkaListener(topics = "${order.topic.name}", 
			groupId = "${order.topic.group.id}",
			containerFactory = "orderKafkaListenerContainerFactory")
	public void topicObject(Order order)
	{
		orderRepository.save(order);
	}
}
