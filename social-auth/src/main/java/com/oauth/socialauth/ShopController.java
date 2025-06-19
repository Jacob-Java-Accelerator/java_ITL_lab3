package com.oauth.socialauth;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

  @GetMapping("/")
  public ResponseEntity<OAuth2User> shopMain(Authentication authentication) {
    OAuth2User user = (OAuth2User) authentication.getPrincipal();

    return ResponseEntity.ok(user);
  }
}
