package com.example.cache.dao;

import com.example.cache.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person,Integer> {
}
