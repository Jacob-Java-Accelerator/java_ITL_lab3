package com.micro.orderservice.order;

import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.apache.bcel.Repository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.micro.orderservice.lib.dto.ProductDto;
import com.micro.orderservice.lib.feign.ProductFeignClient;

@Service
public class OrderService {

  private final OrderRepository orderRepository;
  private final ProductFeignClient productFeignClient;

  public OrderService(OrderRepository orderRepository, ProductFeignClient productFeignClient) {
    this.orderRepository = orderRepository;
    this.productFeignClient = productFeignClient;
  }

  public OrderResponse getOrder(Long orderId) {
    Order order = this.orderRepository.findById(orderId)
        .orElseThrow(() -> new IllegalArgumentException("could not get order"));

    ProductDto product = getProduct(order.getProductId());
    return new OrderResponse(orderId, order.getProductId(), order.getEmail(), product, order.getCreatedAt());
  }

  public OrderResponse placeOrder(OrderRequest order) {

    ProductDto product = getProduct(order.productId());

    if (product.stockQuantity() < order.quantity())
      throw new IllegalArgumentException("product has less stock than quantity");

    Order savedOrder = orderRepository.save(new Order(product.id(), order.email()));
    // reduce stock
    return new OrderResponse(
        savedOrder.getId(),
        savedOrder.getProductId(),
        savedOrder.getEmail(),
        product,
        savedOrder.getCreatedAt());
  }

  public List<OrderResponse> getAllOrdersByEmail(String email) {
    List<Order> orders = orderRepository.findAllByEmail(email);

    List<ProductDto> products = getAllProducts();

    return orders.stream()
        .map(order -> {
          ProductDto product = products.stream()
              .filter(p -> p.id().equals(order.getProductId()))
              .findFirst()
              .orElse(null);

          return new OrderResponse(order.getId(), order.getProductId(), order.getEmail(), product,
              order.getCreatedAt());
        })
        .collect(Collectors.toList());
  };

  public List<OrderResponse> getAllOrders() {
    List<Order> orders = orderRepository.findAll();

    List<ProductDto> products = getAllProducts();

    return orders.stream()
        .map(order -> {
          ProductDto product = products.stream()
              .filter(p -> p.id().equals(order.getProductId()))
              .findFirst()
              .orElse(null);

          return new OrderResponse(order.getId(), order.getProductId(), order.getEmail(), product,
              order.getCreatedAt());
        })
        .collect(Collectors.toList());
  };

  private List<ProductDto> getAllProducts() {
    return this.productFeignClient.getAllProducts();
  }

  private ProductDto getProduct(Long id) {
    return productFeignClient.getProductById(id);
  }

}
