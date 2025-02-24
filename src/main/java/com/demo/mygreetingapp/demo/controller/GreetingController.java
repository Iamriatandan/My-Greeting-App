package com.demo.mygreetingapp.demo.controller;

import com.demo.mygreetingapp.demo.model.GreetingEntity;
import com.demo.mygreetingapp.demo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private final GreetingService greetingService;

    @Autowired  // ✅ Ensure Dependency Injection Works
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

    // ✅ POST Request - Saves a greeting message
    @PostMapping
    public GreetingEntity saveGreeting(@RequestBody GreetingEntity greeting) {
        return greetingService.saveGreeting(greeting.getMessage());
    }

    // ✅ GET - Fetch All Greetings
    @GetMapping("/all")
    public List<GreetingEntity> getAllGreeting() {
        return greetingService.getAllGreeting();  // ✅ Fixed issue
    }

    // ✅ GET - Fetch Greeting by ID
    @GetMapping("/{id}")
    public Optional<GreetingEntity> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        return "Greeting with ID " + id + " has been deleted successfully.";
    }

}
