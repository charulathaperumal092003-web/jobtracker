package com.example.jobtracker.ControllerLayer;

import com.example.jobtracker.DTOLayer.JobTrackerDto;
import com.example.jobtracker.EntityLayer.JobTrackerEntity;
import com.example.jobtracker.ServiceLayer.JobTrackerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobTrackerController {
    private final JobTrackerService service ;
     public JobTrackerController(JobTrackerService service) {
         this.service= service;
     }
    @PostMapping
    public JobTrackerEntity createApplication(
         @Valid @RequestBody JobTrackerDto dto) {

        return service.createApplication(dto);
    }
    @GetMapping
    public List<JobTrackerEntity> getAllApplications() {
        return service.getAllApplications();
    }
    @GetMapping("/{id}")
    public JobTrackerEntity getApplicationById(@PathVariable Long id) {
        return service.getApplicationById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteApplication(@PathVariable Long id) {
        service.deleteApplication(id);
        return "Job application deleted successfully";
    }
    @PutMapping("/{id}")
    public JobTrackerEntity updateApplication(
            @PathVariable Long id,
            @Valid @RequestBody JobTrackerDto dto) {

        return service.updateApplication(id, dto);
    }
}
