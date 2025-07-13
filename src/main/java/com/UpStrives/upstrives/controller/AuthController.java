package com.UpStrives.upstrives.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.UpStrives.upstrives.dto.AuthRequest;
import com.UpStrives.upstrives.dto.AuthResponse;
import com.UpStrives.upstrives.dto.UserRegistryDto;
import com.UpStrives.upstrives.service.AuthService;

public class AuthController {

  @Autowired
  private AuthService authService;

  @PostMapping("/register")
  public String register(@RequestBody UserRegistryDto request) {
    authService.register(request);
    return "User registered successfully";
  }

  @PostMapping("/login")
  public AuthResponse login(@RequestBody AuthRequest request) {
    return authService.login(request);
  }

}
