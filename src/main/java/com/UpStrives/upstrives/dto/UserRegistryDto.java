package com.UpStrives.upstrives.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_registry")
public class UserRegistryDto {

  private String name;
  private String email;
  private String password;
}
