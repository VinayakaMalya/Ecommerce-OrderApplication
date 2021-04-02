package com.ecommerce.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.order.model.OrderPayments;

public interface OrderPaymentsRepository extends JpaRepository<OrderPayments,Long>{

}
