package com.UpStrives.upstrives.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UpStrives.upstrives.entity.UserEntity;
import com.UpStrives.upstrives.entity.UserInternshipsEntity;

public interface UserInternshipRepository extends JpaRepository<UserInternshipsEntity, Long> {

  List<UserInternshipsEntity> findByUser(UserEntity user);

}
