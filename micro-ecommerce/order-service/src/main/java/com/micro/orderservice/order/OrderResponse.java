package com.micro.orderservice.order;

import java.time.LocalDateTime;

import com.micro.orderservice.lib.dto.ProductDto;

public record OrderResponse(Long id, Long productId, String email, ProductDto product, LocalDateTime createdAt) {
}
