package com.example.linkedin.controller;

import com.example.linkedin.model.Profile;
import com.example.linkedin.repositories.ProfileRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    final
    ProfileRepository profileRepository;

    public ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @GetMapping
    public List<Profile> showProfiles() {
        return profileRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Profile get(@PathVariable Integer id) {
        return profileRepository.findById(id).get();
    }

    @PostMapping
    public Profile createProfile(@RequestBody Profile profile) {
        return profileRepository.save(profile);
    }

    @PutMapping("/{id}")
    public Profile updateProfile(@PathVariable Integer id, @RequestBody Profile profile) {
        return profileRepository.findById(id)
                .map(oldProfile -> {
                    oldProfile.setFirst_name(profile.getFirst_name());
                    oldProfile.setHeadline(profile.getHeadline());
                    oldProfile.setEmail(profile.getEmail());
                    oldProfile.setImage_url(profile.getImage_url());
                    oldProfile.setLast_name(profile.getLast_name());
                    oldProfile.setPhone(profile.getPhone());
                    oldProfile.setPronoun_id(profile.getPronoun_id());
                    oldProfile.setPassword(profile.getPassword());
                    return profileRepository.save(oldProfile);
                })
                .orElseGet(() -> {
                    profile.setId(id);
                    return profileRepository.save(profile);
                });
    }


    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Integer id) {
        profileRepository.deleteById(id);
    }

}
