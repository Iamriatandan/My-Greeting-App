package com.demo.mygreetingapp.demo.service;

import com.demo.mygreetingapp.demo.model.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public Greeting getGreetingMessage(String firstName , String lastName){
        if(firstName != null && lastName != null){
            return new Greeting("Hello" + firstName + " " + lastName);
        }
        else if(firstName!=null){
            return new Greeting("Hello" + firstName + "!" );
        } else if (lastName != null) {
            return new Greeting("Hello " + lastName + "!");
        }
        else {
            return new Greeting("Hello World !");
        }
    }
}
