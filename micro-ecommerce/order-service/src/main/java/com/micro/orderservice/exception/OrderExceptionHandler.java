package com.micro.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderExceptionHandler {

  @ExceptionHandler({ IllegalArgumentException.class })
  public ResponseEntity<OrderException> handleException(Exception exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new OrderException(exception.getMessage(), HttpStatus.BAD_REQUEST.value()));
  }

}
