package com.vinsguru.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinsguru.orderservice.client.ProductClient;
import com.vinsguru.orderservice.client.UserClient;
import com.vinsguru.orderservice.dto.PurchaseOrderRequestDto;
import com.vinsguru.orderservice.dto.PurchaseOrderResponseDto;
import com.vinsguru.orderservice.dto.RequestContext;
import com.vinsguru.orderservice.repository.PurchaseOrderRepository;
import com.vinsguru.orderservice.util.EntityDtoUtil;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class OrderFulfillmentService {

	@Autowired
	private PurchaseOrderRepository orderRepository;

	@Autowired
	private ProductClient productClient;

	@Autowired
	private UserClient userClient;

	public Mono<PurchaseOrderResponseDto> purchaseOrder(Mono<PurchaseOrderRequestDto> requestDtoMono) {
		return requestDtoMono.map(RequestContext::new).flatMap(this::productRequestResponse)
				.doOnNext(EntityDtoUtil::setTransactionRequestDto).flatMap(this::usertRequestResponse)
				.map(EntityDtoUtil::getPurchaseOrder).map(this.orderRepository::save)
				.map(EntityDtoUtil::getPurchaseOrderResponseDto).subscribeOn(Schedulers.boundedElastic());

	}

	private Mono<RequestContext> productRequestResponse(RequestContext rc) {
		return this.productClient.getProductById(rc.getPurchaseOrderRequestDto().getProductId())
				.doOnNext(rc::setProductDto).thenReturn(rc);
	}

	private Mono<RequestContext> usertRequestResponse(RequestContext rc) {
		return this.userClient.authorizeTransaction(rc.getTransactionRequestDto())
				.doOnNext(rc::setTransactionResponseDto).thenReturn(rc);
	}

}
