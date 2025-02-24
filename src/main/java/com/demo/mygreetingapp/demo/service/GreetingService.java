package com.demo.mygreetingapp.demo.service;

import com.demo.mygreetingapp.demo.model.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public Greeting getGreetingMessage(){
        return new Greeting("Hello, World");
    }
}
