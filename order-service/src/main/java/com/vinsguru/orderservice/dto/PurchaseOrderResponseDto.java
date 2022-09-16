package com.vinsguru.orderservice.dto;

import java.util.Objects;

public class PurchaseOrderResponseDto {

	private Integer orderId;
	private Integer userId;
	private String productId;
	private Integer amount;
	private OrderStatus status;

	public PurchaseOrderResponseDto() {
	}

	public PurchaseOrderResponseDto(Integer orderId, Integer userId, String productId, Integer amount,
			OrderStatus status) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.productId = productId;
		this.amount = amount;
		this.status = status;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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
		return Objects.hash(amount, orderId, productId, status, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseOrderResponseDto other = (PurchaseOrderResponseDto) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(orderId, other.orderId)
				&& Objects.equals(productId, other.productId) && status == other.status
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "PurchaseOrderResponseDto [orderId=" + orderId + ", userId=" + userId + ", productId=" + productId
				+ ", amount=" + amount + ", status=" + status + "]";
	}

}
