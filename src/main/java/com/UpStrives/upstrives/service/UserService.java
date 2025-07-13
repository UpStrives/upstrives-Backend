package com.UpStrives.upstrives.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.UpStrives.upstrives.dto.UserLoginDto;
import com.UpStrives.upstrives.entity.UserEntity;
import com.UpStrives.upstrives.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private boolean isRegistered(String email) {
        UserEntity user = userRepository.findByEmail(email);
        return user != null;
    }

    public String loginUser(UserLoginDto userDto) {
        String email = userDto.getEmail();
        String password = userDto.getPassword();

        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            return "User not registered";
        }

        // Check password using encoder
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return "Invalid credentials";
        }

        return "Login successful";
    }
}
