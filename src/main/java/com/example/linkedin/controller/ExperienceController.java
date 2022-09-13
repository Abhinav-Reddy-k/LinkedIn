package com.example.linkedin.controller;

import com.example.linkedin.model.Experience;
import com.example.linkedin.repositories.ExperienceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experience")
public class ExperienceController {
    final
    ExperienceRepository experienceRepository;


    public ExperienceController(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @GetMapping
    public List<Experience> get() {
        return experienceRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Experience get(@PathVariable Long id) {
        return experienceRepository.findById(id).get();
    }

    @PostMapping
    public Experience createExperience(@RequestBody Experience experience) {
        return experienceRepository.save(experience);
    }

    @PutMapping("/{id}")
    public Experience updateExperience(@PathVariable Long id, @RequestBody Experience experience) {
        return experienceRepository.findById(id)
                .map(oldExperience -> {
                    oldExperience.setJobRole(experience.getJobRole());
                    oldExperience.setCompanyName(experience.getCompanyName());
                    return experienceRepository.save(oldExperience);
                })
                .orElseGet(() -> {
                    experience.setId(id);
                    return experienceRepository.save(experience);
                });
    }


    @DeleteMapping("/{id}")
    public void deleteJobType(@PathVariable Long id) {
        experienceRepository.deleteById(id);
    }
}