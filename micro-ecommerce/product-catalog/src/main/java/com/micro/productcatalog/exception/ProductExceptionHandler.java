package com.micro.productcatalog.exception;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {

  @ExceptionHandler({ IllegalArgumentException.class })
  public ResponseEntity<ProductException> handleException(Exception exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new ProductException(exception.getMessage(), HttpStatus.BAD_REQUEST.value()));
  }

}
