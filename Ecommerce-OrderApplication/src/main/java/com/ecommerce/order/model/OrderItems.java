package com.ecommerce.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "eOrderItems")
@EntityListeners(AuditingEntityListener.class)
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ORDERITEMSID")
	private Long orderItemId;
	
	@Column(name="ITEMID")
	private Long itemId;
	
	@Column(name="ITEMQTY")
	private Integer itemQty;
	
	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Integer getItemQty() {
		return itemQty;
	}

	public void setItemQty(Integer itemQty) {
		this.itemQty = itemQty;
	}

	@Override
	public String toString() {
		return "OrderItems [orderItemId=" + orderItemId + ", itemId=" + itemId + ", itemQty=" + itemQty + "]";
	}
}
