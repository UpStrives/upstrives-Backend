package com.UpStrives.upstrives.dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class ExpertFormDto {

  private String name;
  private String email;
  private String phone;
  private String degree;
  private String domain;
  private MultipartFile resume;
  private MultipartFile payslip;
}
