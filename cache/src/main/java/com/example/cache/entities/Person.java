package com.example.cache.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Person {

    @GeneratedValue
    @Id
    private Integer id;
    private String name;
    private String address;
}
