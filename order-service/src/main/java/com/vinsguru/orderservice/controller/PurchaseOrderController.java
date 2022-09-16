package com.vinsguru.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinsguru.orderservice.dto.PurchaseOrderRequestDto;
import com.vinsguru.orderservice.dto.PurchaseOrderResponseDto;
import com.vinsguru.orderservice.service.OrderFulfillmentService;
import com.vinsguru.orderservice.service.OrderQueryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("order")
public class PurchaseOrderController {

	@Autowired
	private OrderFulfillmentService orderFulfillmentService;

	@Autowired
	private OrderQueryService queryService;

	@PostMapping
	public Mono<PurchaseOrderResponseDto> order(@RequestBody Mono<PurchaseOrderRequestDto> requestDtoMono) {
		return this.orderFulfillmentService.purchaseOrder(requestDtoMono);
	}

	@GetMapping("user/{userId}")
	public Flux<PurchaseOrderResponseDto> getOrdersByUserId(@PathVariable int userId) {
		return this.queryService.getProductUserId(userId);
	}

}
