package com.micro.productcatalog.product;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/v1/products")
  @ResponseStatus(HttpStatus.OK)
  public List<Product> productHome() {
    return this.productService.getAllProduct();
  }

  @GetMapping("/v1/products/{productId}")
  @ResponseStatus(HttpStatus.OK)
  public Product productHome(@PathVariable Long productId) {
    return this.productService.getProduct(productId);
  }

}
