package com.demo.mygreetingapp.demo.controller;
import com.demo.mygreetingapp.demo.model.GreetingEntity;
import com.demo.mygreetingapp.demo.service.GreetingService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/greeting") // works for all
public class GreetingController {
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    // ✅ GET Request - Returns a greeting message
    @GetMapping
    public GreetingEntity getGreeting(
            @RequestParam(name = "firstName", required = false) String firstName,
            @RequestParam(name = "lastName", required = false) String lastName) {
        return greetingService.getGreetingMessage(firstName, lastName);
    }

    //  POST Request - Saves a greeting message
    @PostMapping
    public GreetingEntity saveGreeting(@RequestBody GreetingEntity greeting) {
        return greetingService.saveGreeting(greeting.getMessage());
    }

    //  NEW: GET - Fetch All Greetings
    @GetMapping("/all")
    public List<GreetingEntity> getAllGreetings() {
        return greetingService.getAllGreeting;
    }
}
