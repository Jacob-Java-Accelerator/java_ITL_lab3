package com.micro.orderservice.order;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "email")
  private String email;

  @Column(name = "productId")
  private Long productId;

  @Column(name = "created_at", nullable = false, updatable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;

  public Order(Long productId, String email) {
    this.productId = productId;
    this.email = email;
  }

  public Order() {
  }

  public Order(Long id, String email, Long productId, LocalDateTime createdAt) {
    this.id = id;
    this.email = email;
    this.productId = productId;
    this.createdAt = createdAt;
  }

  public Long getProductId() {
    return this.productId;
  }

  public String getEmail() {
    return this.email;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  public Long getId() {
    return this.id;
  }

}
