package com.demo.mygreetingapp.demo.controller;
import com.demo.mygreetingapp.demo.model.Greeting;
import com.demo.mygreetingapp.demo.service.GreetingService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/greeting") // works for all
public class GreetingController {
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public Greeting getGreeting(
            @RequestParam(name = "firstName", required = false) String firstName,
            @RequestParam(name = "lastName", required = false) String lastName) {
        return greetingService.getGreetingMessage(firstName, lastName);
    }

    // POST Request - Accepts and returns a greeting message
    @PostMapping
    public Greeting postGreeting() {
        return new Greeting("Hello, POST Request!");
    }

    // PUT Request - Updates and returns a greeting message
    @PutMapping
    public Greeting putGreeting() {
        return new Greeting("Hello, PUT Request!");
    }

    // DELETE Request - Deletes a greeting
    @DeleteMapping
    public Greeting deleteGreeting() {
        return new Greeting("Hello, DELETE Request!");
    }
}
