package com.oauth.socialjwt.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oauth.socialjwt.dto.LoginRequest;
import com.oauth.socialjwt.dto.UserResponse;
import com.oauth.socialjwt.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final TokenService tokenService;
  private final AuthenticationManager authenticationManager;

  public AuthController(TokenService tokenService, AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
    this.tokenService = tokenService;
  }

  @PostMapping("/login")
  public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginRequest) {
    Authentication authenticated = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));

    UserDetails user = (UserDetails) authenticated.getPrincipal();
    String token = tokenService.generateToken(authenticated);
    return ResponseEntity.ok(new UserResponse(token, user));
  }

}
