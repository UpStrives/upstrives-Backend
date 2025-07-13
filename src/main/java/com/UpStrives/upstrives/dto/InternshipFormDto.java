package com.UpStrives.upstrives.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternshipFormDto {

  private String name;

  private String phone;

  private String email;

  private String program; // e.g. Web Development, AI/ML, etc.

  private MultipartFile resume;

  private String resumefilename; // Optional, if you want to store the filename separately

  private int time_duration; // Duration of the internship in weeks or months

}
