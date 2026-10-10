package com.example.jobtracker.ServiceLayer;

import com.example.jobtracker.DTOLayer.JobTrackerDto;
import com.example.jobtracker.EntityLayer.JobTrackerEntity;
import com.example.jobtracker.ExceptionLayer.ResourceNotFoundException;
import com.example.jobtracker.ReponsitaryLayer.JobTrackerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTrackerService {
    private  final JobTrackerRepository repository ;

    public JobTrackerService(JobTrackerRepository repository)
    {
        this.repository = repository;
    }

    public JobTrackerEntity createApplication(JobTrackerDto dto)
    {
        JobTrackerEntity application = new JobTrackerEntity();
        application.setUserId(dto.getUserId());
        application.setCompanyName(dto.getCompanyName());
        application.setJobRole(dto.getJobRole());
        application.setStatus(dto.getStatus());
        application.setAppliedDate(dto.getAppliedDate());
        return repository.save(application);
    }
    public List<JobTrackerEntity> getAllApplications() {
        return repository.findAll();
    }

    public JobTrackerEntity getApplicationById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job application not found with id: " + id));
    }

    public void deleteApplication(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Job application not found with id: " + id);
        }
        repository.deleteById(id);
    }
    public JobTrackerEntity updateApplication(Long id, JobTrackerDto dto) {

        JobTrackerEntity application = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job application not found with id: " +id));

        application.setUserId(dto.getUserId());
        application.setCompanyName(dto.getCompanyName());
        application.setJobRole(dto.getJobRole());
        application.setStatus(dto.getStatus());
        application.setAppliedDate(dto.getAppliedDate());

        return repository.save(application);
    }
}
