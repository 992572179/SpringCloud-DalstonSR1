package com.example.cache;

import com.example.cache.entities.Person;
import com.example.cache.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class CacheApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<String, Person> redisTemplate;

    @Autowired
    PersonService service;

    @Test
    void contextLoads() {
    }

    @Test
    void testRedisSetOps() {
        stringRedisTemplate.opsForValue().set("k1", "v1");
        stringRedisTemplate.opsForValue().set("k2", "v2");
    }

    @Test
    void testRedisValObj() {
        Person person = service.searchPerson(8);
        redisTemplate.opsForValue().set("person", person);
    }

}
