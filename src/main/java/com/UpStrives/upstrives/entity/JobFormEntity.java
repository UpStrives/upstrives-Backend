package com.UpStrives.upstrives.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "JobRequestForm")
@NoArgsConstructor
@Data
public class JobFormEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  private String phoneNumber;
  private String university;
  private String degree;

  @Lob
  private byte[] resume;
  private String coverletter;
}
