package com.ecommerce.order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrderPayments")
public class OrderPayments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderPaymentId;
	
	private Long orderId;
	
	private Long paymentId;

	public Long getOrderPaymentId() {
		return orderPaymentId;
	}

	public void setOrderPaymentId(Long orderPaymentId) {
		this.orderPaymentId = orderPaymentId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
}
