package com.UpStrives.upstrives.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactUsFormDto {

  private String name;
  private String email;
  private String subject_message;
  private String message;

}
