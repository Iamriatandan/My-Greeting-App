package com.demo.mygreetingapp.demo.service;

import com.demo.mygreetingapp.demo.model.GreetingEntity;
import com.demo.mygreetingapp.demo.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {
    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // ✅ Generate and Save Greeting Message
    public GreetingEntity getGreetingMessage(String firstName, String lastName) {
        String message;
        if (firstName != null && lastName != null) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello, " + lastName + "!";
        } else {
            message = "Hello, World!";
        }

        GreetingEntity greeting = new GreetingEntity(message);
        return greetingRepository.save(greeting);  // ✅ Saves & Generates ID
    }

    // ✅ Save a Greeting Message
    public GreetingEntity saveGreeting(String message) {
        GreetingEntity greeting = new GreetingEntity(message);
        return greetingRepository.save(greeting);
    }

    // ✅ Fetch All Greetings
    public List<GreetingEntity> getAllGreeting() {  // ✅ Fixed Method Name
        return greetingRepository.findAll();
    }

    // ✅ Fetch Greeting by ID
    public Optional<GreetingEntity> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    public void deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);  // ✅ Deletes the greeting
        } else {
            throw new RuntimeException("Greeting not found with ID: " + id);
        }
    }

}

