package com.micro.orderservice.order;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

  public final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/v1/orders/{orderId}")
  public ResponseEntity<OrderResponse> getOrder(@PathVariable Long orderId) {
    return ResponseEntity.ok(this.orderService.getOrder(orderId));
  }

  @GetMapping("/v1/orders")
  public ResponseEntity<List<OrderResponse>> getAllOrders(
      @RequestParam(name = "email", required = false) String email) {
    if (email != null)
      return ResponseEntity.ok(this.orderService.getAllOrdersByEmail(email));
    return ResponseEntity.ok(this.orderService.getAllOrders());
  }

  @PostMapping("/v1/orders")
  public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
    return ResponseEntity.ok(this.orderService.placeOrder(orderRequest));
  }

}
