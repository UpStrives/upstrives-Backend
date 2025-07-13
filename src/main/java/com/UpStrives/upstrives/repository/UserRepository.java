package com.UpStrives.upstrives.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UpStrives.upstrives.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
  // Additional query methods can be defined here if needed
  Optional<UserEntity> findByEmail(String email);

}
