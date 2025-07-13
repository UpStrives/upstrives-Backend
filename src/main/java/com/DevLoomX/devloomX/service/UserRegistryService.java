package com.DevLoomX.devloomX.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.DevLoomX.devloomX.repository.UserRegistryRepository;

public class UserRegistryService {

  @Autowired
  public UserRegistryRepository userRegistryRepository;

  public String registerUser(UserRegistryDto userRegistryDto) {
    UserRegistry userRegistry = new UserRegistry();
    userRegistry.setname(userRegistryDto.getname());
    userRegistry.setEmail(userRegistryDto.getEmail());
    userRegistry.setPassword(userRegistryDto.getPassword());
    userRegistry.setPhoneNumber(userRegistryDto.getPhoneNumber());

    userRegistryRepository.save(userRegistry);
    return "User registered successfully";

  }
}
