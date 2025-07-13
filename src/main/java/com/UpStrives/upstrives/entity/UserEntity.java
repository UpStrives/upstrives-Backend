package com.UpStrives.upstrives.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private String email;
  private String password;

  // @ManyToMany
  // @JoinTable(name = "user_guide", joinColumns = @JoinColumn(name = "user_id"),
  // inverseJoinColumns = @JoinColumn(name = "guide_id"))
  // private Set<Guide> guides;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<InternshipEntity> internships;
}
