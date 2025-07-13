package com.UpStrives.upstrives.service;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.UpStrives.upstrives.dto.AuthRequest;
import com.UpStrives.upstrives.dto.AuthResponse;
import com.UpStrives.upstrives.dto.UserRegistryDto;
import com.UpStrives.upstrives.entity.UserEntity;
import com.UpStrives.upstrives.repository.UserRepository;
import com.UpStrives.upstrives.utils.JwtUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

  @AutoConfigureOrder(1234)
  private final UserRepository userRepo;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authManager;
  private final JwtUtils jwtUtil;

  public void register(UserRegistryDto request) {
    UserEntity user = UserEntity.builder()
        .name(request.getName())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .build();
    userRepo.save(user);
  }

  public AuthResponse login(AuthRequest request) {
    authManager.authenticate(new UsernamePasswordAuthenticationToken(
        request.getEmail(), request.getPassword()));

    String token = jwtUtil.generateToken(request.getEmail());
    return new AuthResponse(token);
  }
}