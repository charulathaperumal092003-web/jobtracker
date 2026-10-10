package com.example.jobtracker.EntityLayer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "job_application")
@Setter
@Getter
public class JobTrackerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Integer userId;
    private String companyName;
    private String jobRole;
    private String status;
    private LocalDate appliedDate;
}
