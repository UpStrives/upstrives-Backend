package com.UpStrives.upstrives.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "InternshipRequestForm")
@Data
public class InternshipFormEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String phone;

  private String email;

  private String program; // e.g. Web Development, AI/ML, etc.

  @Lob
  private byte[] resume;
  private String resumefilename;

  private int time_duration;

}
