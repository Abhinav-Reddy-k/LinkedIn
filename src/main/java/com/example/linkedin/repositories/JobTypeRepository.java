package com.example.linkedin.repositories;

import com.example.linkedin.model.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTypeRepository extends JpaRepository<JobType, Integer> {
}
