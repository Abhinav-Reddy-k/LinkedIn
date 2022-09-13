package com.example.linkedin.model;

import jakarta.persistence.*;

@Entity
public class Address {
    private String hNo;
    private String colony;
    private String state;
    private String country;
    private String locality;
    private String city;
    private Long id;
    @OneToOne(mappedBy = "address")
    private Profile profile;

    public Address() {

    }

    public Address(String hNo, String colony, String state, String country, String locality, String city, Long id, Profile profile) {
        this.hNo = hNo;
        this.colony = colony;
        this.state = state;
        this.country = country;
        this.locality = locality;
        this.city = city;
        this.id = id;
        this.profile = profile;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String gethNo() {
        return hNo;
    }

    public void sethNo(String hNo) {
        this.hNo = hNo;
    }

    public String getColony() {
        return colony;
    }

    public void setColony(String colony) {
        this.colony = colony;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
