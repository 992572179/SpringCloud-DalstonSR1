package com.example.cache.controller;

import com.example.cache.entities.Person;
import com.example.cache.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("/add")
    public void addPerson(Person person){
        personService.addPerson(person);
    }


    @DeleteMapping("/del")
    public void delPerson(Integer id){
        personService.delPerson(id);
    }

    @GetMapping("/get/{id}")
    public Person searchPerson(@PathVariable Integer id){
        return personService.searchPerson(id);
    }

    @GetMapping("/list")
    public List<Person> listAll(){
        return personService.getAll();
    }
}
