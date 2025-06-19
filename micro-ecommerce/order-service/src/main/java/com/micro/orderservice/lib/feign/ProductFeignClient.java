package com.micro.orderservice.lib.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.micro.orderservice.lib.dto.ProductDto;

@FeignClient("PRODUCT-CATALOG")
public interface ProductFeignClient {

  @GetMapping("/api/v1/products")
  List<ProductDto> getAllProducts();

  @GetMapping("/api/v1/products/{productId}")
  ProductDto getProductById(@PathVariable Long productId);
}
