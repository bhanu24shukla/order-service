package com.vinsguru.orderservice.dto;

import java.util.Objects;

public class PurchaseOrderRequestDto {

	private Integer userId;
	private String productId;

	public PurchaseOrderRequestDto() {
	}

	public PurchaseOrderRequestDto(Integer userId, String productId) {
		this.userId = userId;
		this.productId = productId;
	}

	public Integer getuserId() {
		return userId;
	}

	public void setuserId(Integer userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PurchaseOrderRequestDto))
			return false;
		PurchaseOrderRequestDto other = (PurchaseOrderRequestDto) obj;
		return Objects.equals(productId, other.productId) && Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "PurchaseOrderRequestDto [userId=" + userId + ", productId=" + productId + "]";
	}

}
