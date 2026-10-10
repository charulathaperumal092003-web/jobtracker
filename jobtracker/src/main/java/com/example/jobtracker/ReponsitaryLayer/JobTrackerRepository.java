package com.example.jobtracker.ReponsitaryLayer;

import com.example.jobtracker.EntityLayer.JobTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTrackerRepository extends JpaRepository<JobTrackerEntity,Long> {
}
