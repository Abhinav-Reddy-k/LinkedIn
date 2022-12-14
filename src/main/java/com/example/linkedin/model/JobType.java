package com.example.linkedin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "jobTypes")
public class JobType {
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "preferedJobType",
            joinColumns = @JoinColumn(name = "job_type_id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id")
    )
    private Set<Profile> preferredProfiles = new HashSet<>();

    public JobType(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public JobType() {

    }

    public Set<Profile> getPreferredProfiles() {
        return preferredProfiles;
    }

    public void setPreferredProfiles(Set<Profile> preferedJobType) {
        this.preferredProfiles = preferedJobType;
    }

    public void addProfileToPreferedJobType(Profile profile) {
        preferredProfiles.add(profile);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
