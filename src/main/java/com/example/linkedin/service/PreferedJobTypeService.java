package com.example.linkedin.service;

import com.example.linkedin.model.JobType;
import com.example.linkedin.model.Profile;
import com.example.linkedin.repositories.JobTypeRepository;
import com.example.linkedin.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreferedJobTypeService {
    @Autowired
    JobTypeRepository jobTypeRepository;

    @Autowired
    ProfileRepository profileRepository;

    public void addPreferedJobType(Integer profile_id,Integer job_type_id){
        Profile profile = profileRepository.findById(profile_id).get();
        JobType jobType = jobTypeRepository.findById(job_type_id).get();
        profile.addPreferedJobType(jobType);
        return
    }
}
