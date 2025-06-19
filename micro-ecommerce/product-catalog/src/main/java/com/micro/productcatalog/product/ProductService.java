package com.micro.productcatalog.product;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> getAllProduct() {
    return this.productRepository.findAll();
  }

  public Product getProduct(Long productId) {
    return this.productRepository.findById(productId)
        .orElseThrow(() -> new IllegalArgumentException("product not found"));
  }
}
