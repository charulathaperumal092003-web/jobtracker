package com.example.jobtracker.DTOLayer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class JobTrackerDto {
    @NotNull(message = "User ID is required")
    private Integer userId;
    @NotBlank(message = "Company name is required")
    private String companyName;
    @NotBlank(message = "Job role is required")
    private String jobRole;
    @NotBlank(message = "Status is required")
    private String status;
    @NotNull(message = "Applied date is required")
    private LocalDate appliedDate;
}
