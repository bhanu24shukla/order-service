package com.vinsguru.orderservice.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.vinsguru.orderservice.dto.OrderStatus;

@Entity
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String productId;
	private Integer userId;
	private Integer amount;
	private OrderStatus status;

	public PurchaseOrder() {
	}

	public PurchaseOrder(String productId, Integer userId, Integer amount, OrderStatus status) {
		this.productId = productId;
		this.userId = userId;
		this.amount = amount;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, id, productId, status, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PurchaseOrder))
			return false;
		PurchaseOrder other = (PurchaseOrder) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(id, other.id)
				&& Objects.equals(productId, other.productId) && status == other.status
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", productId=" + productId + ", userId=" + userId + ", amount=" + amount
				+ ", status=" + status + "]";
	}

}
