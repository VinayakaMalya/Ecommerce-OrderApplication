package com.ecommerce.order.service;

import java.util.Optional;

import com.ecommerce.order.model.Order;

public interface OrderService 
{
	Optional<Order> findOrderById(long orderId);

	Order createOrder(Order order);

	Order cancelOrder(long orderId);
}
