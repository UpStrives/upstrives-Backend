package com.UpStrives.upstrives.utils;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
  private final String secret = "mysecretkey123456";
  private final long expirationMs = 86400000; // 1 day

  public String generateToken(String email) {
    return Jwts.builder()
        .setSubject(email)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
        .signWith(SignatureAlgorithm.HS256, secret)
        .compact();
  }

  public String extractEmail(String token) {
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
  }
}
