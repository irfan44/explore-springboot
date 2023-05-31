package dev.irfannm.exploreSpring.controller;

import dev.irfannm.exploreSpring.model.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @GetMapping("")
    public ResponseEntity<Profile> getProfile() {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(new Profile("123123", "skucit", 19));
    }

    @PostMapping("")
    public ResponseEntity<String> createProfile(@RequestBody Profile profile) {
        if (profile.getName() == null && profile.getAge() == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).body("Add required body to your request");
        } else if (profile.getName() == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).body("Add name to your request");
        } else if (profile.getAge() == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).body("Add age to your request");
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body("Profile created successfully " + profile.getName() + " " + profile.getAge());
        }
    }
}
