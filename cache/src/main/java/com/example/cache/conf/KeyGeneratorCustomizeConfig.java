package com.example.cache.conf;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 自定义的KeyGenerator，生成策略为func[?]    eg. emp[2]
 */
@Configuration
public class KeyGeneratorCustomizeConfig {

    @Bean("defKeyGenerator")
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> method.getName() + "[" + Arrays.asList(params).toString() + "]";
    }
}
