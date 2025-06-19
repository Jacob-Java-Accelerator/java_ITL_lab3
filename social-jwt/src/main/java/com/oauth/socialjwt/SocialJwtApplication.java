package com.oauth.socialjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.oauth.socialjwt.config.RsaKeyProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class SocialJwtApplication {

  public static void main(String[] args) {
    SpringApplication.run(SocialJwtApplication.class, args);
  }

}
