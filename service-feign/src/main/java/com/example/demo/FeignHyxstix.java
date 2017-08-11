package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * Created by kawano on 2017/8/1 9:46.
 */

@Component
public class FeignHyxstix implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "error" + "\t" +name;
    }
}
