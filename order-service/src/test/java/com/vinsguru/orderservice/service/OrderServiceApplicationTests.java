package com.vinsguru.orderservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vinsguru.orderservice.client.ProductClient;
import com.vinsguru.orderservice.client.UserClient;
import com.vinsguru.orderservice.dto.ProductDto;
import com.vinsguru.orderservice.dto.PurchaseOrderRequestDto;
import com.vinsguru.orderservice.dto.PurchaseOrderResponseDto;
import com.vinsguru.orderservice.dto.UserDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class OrderServiceApplicationTests {

	@Autowired
	private ProductClient productClient;

	@Autowired
	private UserClient userClient;

	@Autowired
	private OrderFulfillmentService orderFulfillmentService;

	@Test
	void contextLoads() {
		Flux<Mono<PurchaseOrderResponseDto>> fluxDto = Flux
				.zip(userClient.getAllProducts(), productClient.getAllProducts())
				.map(t -> buildDto(t.getT1(), t.getT2()))
				.map(dto -> this.orderFulfillmentService.processOrder(Mono.just(dto))).doOnNext(System.out::println);

		StepVerifier.create(fluxDto).expectNextCount(4).verifyComplete();
	}

	private PurchaseOrderRequestDto buildDto(UserDto userDto, ProductDto productDto) {
		PurchaseOrderRequestDto dto = new PurchaseOrderRequestDto();
		dto.setuserId(userDto.getId());
		dto.setProductId(productDto.getId());
		return dto;
	}

}
