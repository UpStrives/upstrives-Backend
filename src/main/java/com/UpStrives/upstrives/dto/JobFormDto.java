package com.UpStrives.upstrives.dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobFormDto {
  private String name;
  private String email;
  private String phoneNumber;
  private String university;
  private String degree;
  private MultipartFile resume;
  private String coverletter;
}
