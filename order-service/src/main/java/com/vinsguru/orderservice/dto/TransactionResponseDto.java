package com.vinsguru.orderservice.dto;

import java.util.Objects;

public class TransactionResponseDto {

	private Integer userId;
	private Integer amount;
	private TransactionStatus status;

	public TransactionResponseDto() {
	}

	public TransactionResponseDto(Integer userId, Integer amount, TransactionStatus status) {
		this.userId = userId;
		this.amount = amount;
		this.status = status;
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

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, status, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TransactionResponseDto))
			return false;
		TransactionResponseDto other = (TransactionResponseDto) obj;
		return Objects.equals(amount, other.amount) && status == other.status && Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "TransactionResponseDto [userId=" + userId + ", amount=" + amount + ", status=" + status + "]";
	}

}
