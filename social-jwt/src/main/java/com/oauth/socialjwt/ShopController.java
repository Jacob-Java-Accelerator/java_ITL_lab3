package com.oauth.socialjwt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

  @GetMapping("/")
  public String shopMain() {
    return "welcome to shop";
  }
}
