package com.DevLoomX.devloomX.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobFormController {

  public ResponseEntity<String> submitJobForm(@ModelAttribute JobFormDto jobFormDto) {
    // Convert DTO to Entity
    try {
      JobFormEntity jobFormEntity = new JobFormEntity();
      jobFormEntity.setName(jobFormDto.getName());
      jobFormEntity.setEmail(jobFormDto.getEmail());
      jobFormEntity.setPhoneNumber(jobFormDto.getPhoneNumber());
      jobFormEntity.setResume(jobFormDto.getResume().getBytes());
      jobFormEntity.setResumefilename(jobFormDto.getResumeFilename());

      // Save the entity using the repository
      jobFormRepository.save(jobFormEntity);

      return ResponseEntity.ok("Job form submitted successfully");

    } catch (Exception e) {
      // Handle exceptions and return an error response
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Error submitting job form: " + e.getMessage());
    }

  }

}
