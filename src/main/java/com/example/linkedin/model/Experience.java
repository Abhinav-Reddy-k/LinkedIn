package com.example.linkedin.model;

import jakarta.persistence.*;

@Entity
public class Experience {

    private Long id;
    private String companyName;
    private String jobRole;
    @OneToOne(mappedBy = "experience")
    private Profile profile;

    public Experience(Long id, String companyName, String jobRole, Profile profile) {
        this.id = id;
        this.companyName = companyName;
        this.jobRole = jobRole;
        this.profile = profile;
    }

    public Experience() {
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
