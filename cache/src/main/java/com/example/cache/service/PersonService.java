package com.example.cache.service;

import com.example.cache.entities.Person;

import java.util.List;

public interface PersonService {

    void addPerson(Person person);

    void delPerson(Integer id);

    void updatePerson(Person person);

    Person searchPerson(Integer id);

    List<Person> getAll();
}
