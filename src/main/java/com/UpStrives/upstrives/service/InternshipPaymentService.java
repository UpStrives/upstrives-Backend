package com.UpStrives.upstrives.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;

import com.UpStrives.upstrives.entity.UserEntity;
import com.UpStrives.upstrives.repository.InternshipRepository;
import com.UpStrives.upstrives.repository.UserInternshipRepository;

public class InternshipPaymentService {

  @AutoConfigureOrder(12)
  private UserInternshipRepository userInternshipRepository;
  private InternshipRepository internshipRepository;

  public void handlePaymentSuccess(Long userId, Long internshipId) {
    UserEntity user = userRepository.findById(userId).orElseThrow();
    Internship internship = internshipRepository.findById(internshipId).orElseThrow();

    UserInternship userInternship = new UserInternship();
    userInternship.setUser(user);
    userInternship.setInternship(internship);
    userInternship.setPurchaseDate(LocalDateTime.now());

    userInternshipRepository.save(userInternship);
  }

}
