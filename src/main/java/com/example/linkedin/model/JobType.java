package com.example.linkedin.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class JobType {
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "preferedJobType",
            joinColumns = @JoinColumn(name = "job_type_id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id")
    )
    private Set<JobType> preferedJobType = new HashSet<JobType>();



    public Set<JobType> getPreferedJobType() {
        return preferedJobType;
    }

    public void setPreferedJobType(Set<JobType> preferedJobType) {
        this.preferedJobType = preferedJobType;
    }

    public JobType(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public JobType() {

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
