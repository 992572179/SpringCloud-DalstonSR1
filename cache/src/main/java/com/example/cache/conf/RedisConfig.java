package com.example.cache.conf;


import com.example.cache.entities.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * redis缓存模块的自定义配置
 *  主要重新配置了序列化，使用Jackson2JsonRedisSerializer
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Person> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Person> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Person.class));
        return template;
    }
}
