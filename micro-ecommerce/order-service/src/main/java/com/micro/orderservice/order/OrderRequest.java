package com.micro.orderservice.order;

public record OrderRequest(Long productId, String email, Integer quantity) {

}
