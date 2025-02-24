package com.demo.mygreetingapp.demo.controller;
import com.demo.mygreetingapp.demo.model.Greeting;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/greeting") // works for all
public class GreetingController {
    // GET Request - Returns a greeting message
    @GetMapping
    public Greeting getGreeting() {
        return new Greeting("Hello, GET Request!");
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
