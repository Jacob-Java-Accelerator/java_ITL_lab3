package com.oauth.socialjwt.dto;

import org.springframework.security.core.userdetails.UserDetails;

public record UserResponse(String token, UserDetails email) {
}
