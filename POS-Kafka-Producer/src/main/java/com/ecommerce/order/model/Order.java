package com.ecommerce.order.model;

import java.util.List;

public class Order 
{
	private Long orderId;
	
	private String status;
	
	private Long customerId;
	
	private Double subtotal;
	
	private Double tax;
	
	private Double shippingCharge;
	
	private Double total;
	
	private List<OrderItems> orderItems;
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getShippingCharge() {
		return shippingCharge;
	}

	public void setShippingCharge(Double shippingCharge) {
		this.shippingCharge = shippingCharge;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", status=" + status + ", customerId=" + customerId + ", subtotal="
				+ subtotal + ", tax=" + tax + ", shippingCharge=" + shippingCharge + ", total=" + total
				+ ", orderItems=" + orderItems + "]";
	}
}
