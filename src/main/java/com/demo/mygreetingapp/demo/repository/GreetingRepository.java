package com.demo.mygreetingapp.demo.repository;

import com.demo.mygreetingapp.demo.model.GreetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GreetingRepository extends JpaRepository<GreetingEntity,Long> {
}
