package com.example.demo;

/**
 * Created by Administrator on 2017/7/20.
 */
public class Lock {

    private String name;
    private String value;

    public Lock(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

}
