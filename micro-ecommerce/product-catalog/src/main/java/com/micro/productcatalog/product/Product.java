package com.micro.productcatalog.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description", length = 1000)
  private String description;

  @Column(name = "price", nullable = false)
  private BigDecimal price;

  @Column(name = "category", nullable = false)
  private String category;

  @Column(name = "brand", nullable = false)
  private String brand;

  @Column(name = "stock_quantity")
  private Integer stockQuantity;

}
