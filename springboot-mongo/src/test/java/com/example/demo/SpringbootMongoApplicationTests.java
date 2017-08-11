package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMongoApplicationTests {

    private static Logger log = LoggerFactory.getLogger(SpringbootMongoApplicationTests.class);

    //private static final Logger log = Logger.getLogger(SpringbootMongoApplicationTests.class);

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void mongodbIdTest() {
        Customer customer = new Customer("kawano1", "tsunenori");
        customer = customerRepository.save(customer);
        log.info("mongodbId------------------->" + customer.getId());
        //597e7e81f522360fd0388bf6
        //597e7e96f522360f40b345ce
    }

    @Test
    public void getCustomer() {
        Customer customer = customerRepository.findByFirstName("kawano1");
        log.info(customer.getLastName());
        log.info(customer.getId());

    }

}
