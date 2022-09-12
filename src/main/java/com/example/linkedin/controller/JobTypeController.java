package com.example.linkedin.controller;

import com.example.linkedin.model.JobType;
import com.example.linkedin.repositories.JobTypeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobtypes")
public class JobTypeController {
    final
    JobTypeRepository jobTypeRepository;

    public JobTypeController(JobTypeRepository jobTypeRepository) {
        this.jobTypeRepository = jobTypeRepository;
    }

    @GetMapping
    public List<JobType> showJobTypes() {
        return jobTypeRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public JobType get(@PathVariable Integer id){
        return jobTypeRepository.findById(id).get();
    }

    @PostMapping
    public JobType createJobType(@RequestBody JobType jobType){
        return jobTypeRepository.save(jobType);
    }

    @PutMapping("/{id}")
    public JobType updateJobType(@PathVariable Integer id, @RequestBody JobType jobType){
        return jobTypeRepository.findById(id)
                .map(oldJobType -> {
                    oldJobType.setName(jobType.getName());
                    return jobTypeRepository.save(oldJobType);
                })
                .orElseGet(() -> {
                    jobType.setId(id);
                    return jobTypeRepository.save(jobType);
                });
    }


    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Integer id){
        jobTypeRepository.deleteById(id);
    }

}
