package com.UpStrives.upstrives.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UpStrives.upstrives.dto.JobFormDto;
import com.UpStrives.upstrives.entity.JobFormEntity;
import com.UpStrives.upstrives.repository.JobFormRepository;

@Service
public class JobFormService {

  @Autowired
  private JobFormRepository jobFormRepository;

  public String validateJobForm(JobFormDto jobFormDto) {
    JobFormEntity jobFormEntity = new JobFormEntity();
    jobFormEntity.setName(jobFormDto.getName());
    jobFormEntity.setEmail(jobFormDto.getEmail());
    jobFormEntity.setPhoneNumber(jobFormDto.getPhoneNumber());
    jobFormEntity.setUniversity(jobFormDto.getUniversity());
    jobFormEntity.setDegree(jobFormDto.getDegree());
    try {
      jobFormEntity.setResume(jobFormDto.getResume().getBytes());
    } catch (Exception e) {
      throw new RuntimeException("Failed to process resume file", e);
    }
    jobFormEntity.setCoverletter(jobFormDto.getCoverletter());

    jobFormRepository.save(jobFormEntity);

    // SendConfirmationEmail(jobFormDto.getEmail());
    return "Job form submitted successfully";

  }

  // Additional validation can be added as needed

  /*
   * private void SendConfirmationEmail(String email) {
   * String subject = "Job Application Confirmation";
   * String text =
   * "Thank you for applying for the job. We will review your application and get back to you soon.\n\nBest regards,\nDevLoomX Team"
   * ;
   * SimpleMailMessage message = new SimpleMailMessage();
   * message.setTo(email);
   * message.setSubject(subject);
   * message.setText(text);
   * message.setFrom("your_email@gmail.com");
   * 
   * mailSender.send(message);
   * System.out.println("Confirmation email sent to: " + email);
   * }
   */

}
