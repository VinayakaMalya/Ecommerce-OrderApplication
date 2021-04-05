package com.ecommerce.order.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="eOrder")
@EntityListeners(AuditingEntityListener.class)
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ORDERID")
	private Long orderId;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="CUSTOMERID")
	private Long customerId;
	
	@Column(name="SUBTOTAL")
	private Double subtotal;
	
	@Column(name="TAX")
	private Double tax;
	
	@Column(name="SHIPPINGCHARGE")
	private Double shippingCharge;
	
	@Column(name="TOTAL")
	private Double total;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="ORDERID")
	private List<OrderItems> orderItems;
		
	@CreatedDate
	@Column(name="CREATEDDATE")
	private Date createdDate;
	
	@LastModifiedDate
	@Column(name="MODIFIEDDATE")
	private Date modifiedDate;

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
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
				+ ", orderItems=" + orderItems + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
				+ "]";
	}
}
