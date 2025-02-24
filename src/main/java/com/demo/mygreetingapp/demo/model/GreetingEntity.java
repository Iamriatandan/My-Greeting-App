package com.demo.mygreetingapp.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "greetings")  // ✅ Changed table name (optional fix)
public class GreetingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ✅ Auto-generated ID
    private Long id;

    private String message;

    public GreetingEntity() {}

    public GreetingEntity(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {  // ✅ Optional setter
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
