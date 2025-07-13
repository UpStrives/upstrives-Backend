package com.UpStrives.upstrives.entity;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class UserInternshipsEntity {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private UserEntity user;

  @ManyToOne
  private InternshipEntity internshipEntity;

  private LocalDateTime purchaseDate;

  public InternshipEntity getInternship() {
    return this.internshipEntity;
  }
}
