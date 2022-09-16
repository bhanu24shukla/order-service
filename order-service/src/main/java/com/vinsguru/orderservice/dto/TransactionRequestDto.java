package com.vinsguru.orderservice.dto;

import java.util.Objects;

public class TransactionRequestDto {

	private Integer userId;
	private Integer amount;

	public TransactionRequestDto() {
	}

	public TransactionRequestDto(Integer userId, Integer amount) {
		super();
		this.userId = userId;
		this.amount = amount;
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

	@Override
	public int hashCode() {
		return Objects.hash(amount, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TransactionRequestDto))
			return false;
		TransactionRequestDto other = (TransactionRequestDto) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "TransactionRequestDto [userId=" + userId + ", amount=" + amount + "]";
	}

}
