package com.ecommerce.order.service;

import com.ecommerce.order.model.Order;

public interface OrderProducerService {

	void saveCreateorUpdateOrder(Order order);
}
