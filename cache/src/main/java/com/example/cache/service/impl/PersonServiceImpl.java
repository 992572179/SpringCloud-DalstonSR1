package com.example.cache.service.impl;

import com.example.cache.dao.PersonDao;
import com.example.cache.entities.Person;
import com.example.cache.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *  Cacheable
 *  CachePut
 *  CacheEvict 注解的使用
 */
@CacheConfig(cacheNames = {"emp-cache"}, keyGenerator = "defKeyGenerator")
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }


    @Override
    public void addPerson(Person person) {
        person.setAddress("shijiazhuang");
        person.setName("ww");
        personDao.saveAndFlush(person);
    }

    @CacheEvict(beforeInvocation = true)
    @Override
    public void delPerson(Integer id) {
        personDao.deleteById(id);
    }

    @CachePut
    @Override
    public void updatePerson(Person person) {
        personDao.saveAndFlush(person);
    }

    @Cacheable()
    @Override
    public Person searchPerson(Integer id) {
        if (personDao.findById(id).isPresent()) {
            return personDao.findById(id).get();
        }
        return null;
    }

    @Cacheable()
    @Override
    public List<Person> getAll() {
        return personDao.findAll();
    }
}
