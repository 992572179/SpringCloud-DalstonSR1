package com.example.cache.service.impl;

import com.example.cache.dao.PersonDao;
import com.example.cache.entities.Person;
import com.example.cache.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;


    @Override
    public void addPerson(Person person) {
        person.setId(1001);
        person.setAddress("wuhan");
        person.setName("zs");
        personDao.saveAndFlush(person);
    }

    @Override
    public void delPerson(Integer id) {
        personDao.deleteById(id);
    }

    @Override
    public void updatePerson(Person person) {
        personDao.saveAndFlush(person);
    }

    @Cacheable(value = "jpa-cache",key = "#id")
    @Override
    public Person searchPerson(Integer id) {
        Person person =  personDao.findById(id).get();
        return person;
    }

    @Override
    public List<Person> getAll() {
        return personDao.findAll();
    }
}
