package com.example.cache.controller;

import com.example.cache.entities.Person;
import com.example.cache.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    final
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/add")
    public String addPerson(Person person) {
        personService.addPerson(person);
        return "success";
    }


    @DeleteMapping("/del/{id}")
    public String delPerson(@PathVariable Integer id) {
        personService.delPerson(id);
        return "success";
    }

    @GetMapping("/get/{id}")
    public Person searchPerson(@PathVariable Integer id) {
        return personService.searchPerson(id);
    }

    @GetMapping("/list")
    public List<Person> listAll() {
        return personService.getAll();
    }

    @PutMapping("/update/{id}")
    public String updatePerson(@PathVariable Integer id){
        Person person = personService.searchPerson(id);
        person.setName("jojo");
        person.setAddress("tokyo");
        personService.updatePerson(person);
        return "success";
    }
}
