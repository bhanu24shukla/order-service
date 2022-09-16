package com.vinsguru.orderservice.util;

import org.springframework.beans.BeanUtils;

import com.vinsguru.orderservice.dto.OrderStatus;
import com.vinsguru.orderservice.dto.PurchaseOrderResponseDto;
import com.vinsguru.orderservice.dto.RequestContext;
import com.vinsguru.orderservice.dto.TransactionRequestDto;
import com.vinsguru.orderservice.dto.TransactionStatus;
import com.vinsguru.orderservice.entity.PurchaseOrder;

public class EntityDtoUtil {

	public static PurchaseOrderResponseDto getPurchaseOrderResponseDto(PurchaseOrder purchaseOrder) {
		PurchaseOrderResponseDto dto = new PurchaseOrderResponseDto();
		BeanUtils.copyProperties(purchaseOrder, dto);
		dto.setOrderId(purchaseOrder.getId());
		return dto;
	}

	public static void setTransactionRequestDto(RequestContext rc) {
		TransactionRequestDto dto = new TransactionRequestDto();
		dto.setUserId(rc.getPurchaseOrderRequestDto().getuserId());
		dto.setAmount(rc.getProductDto().getPrice());
		rc.setTransactionRequestDto(dto);
	}

	public static PurchaseOrder getPurchaseOrder(RequestContext rc) {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.setUserId(rc.getPurchaseOrderRequestDto().getuserId());
		purchaseOrder.setProductId(rc.getPurchaseOrderRequestDto().getProductId());
		purchaseOrder.setAmount(rc.getProductDto().getPrice());

		TransactionStatus status = rc.getTransactionResponseDto().getStatus();
		OrderStatus orderStatus = TransactionStatus.APPROVED.equals(status) ? OrderStatus.COMPLETED
				: OrderStatus.FAILED;
		purchaseOrder.setStatus(orderStatus);
		return purchaseOrder;
	}

}
