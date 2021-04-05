package com.ecommerce.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.order.model.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems,Long>{

}
