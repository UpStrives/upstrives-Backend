package com.UpStrives.upstrives.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.UpStrives.upstrives.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

  @Autowired
  private UserRepository userRepository;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeHttpRequests()
        .requestMatchers("/api/auth/**").permitAll()
        .anyRequest().authenticated();
    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    return email -> {
      com.UpStrives.upstrives.entity.UserEntity user = userRepository.findByEmail(email)
          .orElseThrow(() -> new RuntimeException("User not found"));
      return org.springframework.security.core.userdetails.User.builder()
          .username(user.getEmail())
          .password(user.getPassword())
          .roles("USER")
          .build();
    };
  }

  @Bean
  public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,
      PasswordEncoder passwordEncoder) {
    var provider = new org.springframework.security.authentication.dao.DaoAuthenticationProvider(userDetailsService);
    provider.setPasswordEncoder(passwordEncoder);
    return new ProviderManager(provider);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}