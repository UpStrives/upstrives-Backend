package com.UpStrives.upstrives.entity;

import org.hibernate.mapping.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "expert")
public class ExpertEntity {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private String domain;
  private String company;

  // @ManyToMany(mappedBy = "guides")
  // private Set<User> users;

}
