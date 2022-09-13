package com.example.linkedin.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Profile {
    @ManyToMany(mappedBy = "preferedProfiles")
    private final Set<JobType> jobTypes = new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String first_name;
    private String last_name;
    private String headline;
    @NonNull
    private String email;
    private String image_url;
    private String password;
    private String phone;
    private Integer pronoun_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    public Profile() {
        super();
    }

    public Profile(Integer id, String first_name, String last_name, String headline, String email, String image_url, String password, String phone, Integer pronoun_id) {
        super();
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.headline = headline;
        this.email = email;
        this.image_url = image_url;
        this.password = password;
        this.phone = phone;
        this.pronoun_id = pronoun_id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<JobType> getJobTypes() {
        return jobTypes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer profile_id) {
        this.id = profile_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPronoun_id() {
        return pronoun_id;
    }

    public void setPronoun_id(Integer pronoun_id) {
        this.pronoun_id = pronoun_id;
    }
}
