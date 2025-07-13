package com.UpStrives.upstrives.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.UpStrives.upstrives.dto.UserLoginDto;
import com.UpStrives.upstrives.service.UserService;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  // Example method for user login

  @PutMapping("/register")
  public ResponseEntity<String> registerUser(@RequestBody UserRegistryDto userRegistryDto) {
    try {
      String response = userService.registerUser(userRegistryDto);
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      // Handle exception, e.g., return an error response
      return ResponseEntity.status(500).body("Registration failed: " + e.getMessage());
    }
  }

  @PostMapping("/login")
  public ResponseEntity<String> loginUser(@RequestBody UserLoginDto userLoginDto) {
    try {
      String response = userService.LoginUser(userLoginDto);
      if (response.contains("Invalid email or password")) {
        throw new RuntimeException("Login failed: " + response);
      }
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      // TODO: handle exception
    }

  }

  // Additional methods for logout, session management, etc. can be added here

}
