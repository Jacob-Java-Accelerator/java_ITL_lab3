package com.micro.orderservice.lib.dto;

import java.math.BigDecimal;

public record ProductDto(
    Long id,
    String name,
    String description,
    BigDecimal price,
    String category,
    String brand,
    Integer stockQuantity) {
}
