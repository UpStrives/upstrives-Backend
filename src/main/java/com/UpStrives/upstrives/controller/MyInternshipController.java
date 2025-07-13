package com.UpStrives.upstrives.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UpStrives.upstrives.entity.InternshipEntity;
import com.UpStrives.upstrives.entity.UserEntity;
import com.UpStrives.upstrives.entity.UserInternshipsEntity;
import com.UpStrives.upstrives.repository.UserInternshipRepository;
import com.UpStrives.upstrives.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/my-internships")
@RequiredArgsConstructor
public class MyInternshipController {

  private final UserInternshipRepository userInternshipRepository;
  private final UserRepository userRepository;

  @GetMapping
  public ResponseEntity<List<InternshipEntity>> getMyInternships(Authentication authentication) {
    String email = authentication.getName(); // if using JWT, username = email
    UserEntity user = userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    List<InternshipEntity> internships = userInternshipRepository
        .findByUser(user)
        .stream()
        .map(UserInternshipsEntity::getInternship)
        .toList();

    return ResponseEntity.ok(internships);
  }
}
