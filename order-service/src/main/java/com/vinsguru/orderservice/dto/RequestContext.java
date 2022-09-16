package com.vinsguru.orderservice.dto;

import java.util.Objects;

public class RequestContext {

	private PurchaseOrderRequestDto purchaseOrderRequestDto;
	private ProductDto productDto;
	private TransactionRequestDto transactionRequestDto;
	private TransactionResponseDto transactionResponseDto;

	public RequestContext() {
	}

	public RequestContext(PurchaseOrderRequestDto purchaseOrderRequestDto) {
		this.purchaseOrderRequestDto = purchaseOrderRequestDto;
	}

	public RequestContext(PurchaseOrderRequestDto purchaseOrderRequestDto, ProductDto productDto,
			TransactionRequestDto transactionRequestDto, TransactionResponseDto transactionResponseDto) {
		this.purchaseOrderRequestDto = purchaseOrderRequestDto;
		this.productDto = productDto;
		this.transactionRequestDto = transactionRequestDto;
		this.transactionResponseDto = transactionResponseDto;
	}

	public PurchaseOrderRequestDto getPurchaseOrderRequestDto() {
		return purchaseOrderRequestDto;
	}

	public void setPurchaseOrderRequestDto(PurchaseOrderRequestDto purchaseOrderRequestDto) {
		this.purchaseOrderRequestDto = purchaseOrderRequestDto;
	}

	public ProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

	public TransactionRequestDto getTransactionRequestDto() {
		return transactionRequestDto;
	}

	public void setTransactionRequestDto(TransactionRequestDto transactionRequestDto) {
		this.transactionRequestDto = transactionRequestDto;
	}

	public TransactionResponseDto getTransactionResponseDto() {
		return transactionResponseDto;
	}

	public void setTransactionResponseDto(TransactionResponseDto transactionResponseDto) {
		this.transactionResponseDto = transactionResponseDto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productDto, purchaseOrderRequestDto, transactionRequestDto, transactionResponseDto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof RequestContext))
			return false;
		RequestContext other = (RequestContext) obj;
		return Objects.equals(productDto, other.productDto)
				&& Objects.equals(purchaseOrderRequestDto, other.purchaseOrderRequestDto)
				&& Objects.equals(transactionRequestDto, other.transactionRequestDto)
				&& Objects.equals(transactionResponseDto, other.transactionResponseDto);
	}

	@Override
	public String toString() {
		return "RequestContext [purchaseOrderRequestDto=" + purchaseOrderRequestDto + ", productDto=" + productDto
				+ ", transactionRequestDto=" + transactionRequestDto + ", transactionResponseDto="
				+ transactionResponseDto + "]";
	}

}
