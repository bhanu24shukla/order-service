package com.vinsguru.orderservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.vinsguru.orderservice.dto.TransactionRequestDto;
import com.vinsguru.orderservice.dto.TransactionResponseDto;

import reactor.core.publisher.Mono;

@Service
public class UserClient {

	private final WebClient webClient;

	public UserClient(@Value("${user.service.url}") String url) {
		this.webClient = WebClient.builder().baseUrl(url).build();
	}

	public Mono<TransactionResponseDto> authorizeTransaction(TransactionRequestDto transactionRequestDto) {
		return this.webClient.post().uri("transaction").bodyValue(transactionRequestDto).retrieve()
				.bodyToMono(TransactionResponseDto.class);
	}

}
