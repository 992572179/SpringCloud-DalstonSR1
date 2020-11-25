package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author wangzy
 * @date 2020年11月18日
 * 使用setnx实现分布式锁
 */
@Slf4j
@RestController
public class StockController {

    @Autowired
    private StringRedisTemplate redisTemplate;


    @GetMapping("/sale1")
    public String saleProduct() {
        //产品库存在Redis中的键
        String productStockKey = "prod:AE3012:stock";
        //nx锁
        String lockName = "prod:lock";
        String clientId = UUID.randomUUID().toString();

        try {
            //设置nx锁，并设置超时时间
            Boolean ifAbsent = redisTemplate.opsForValue().setIfAbsent(lockName, clientId, 30, TimeUnit.SECONDS);
            //如果锁已经存在，则说明有其他请求已经创建过锁，且还未删除，直接return
            if (!ifAbsent) {
                log.error("--------->nx锁已经存在！");
                return "error";
            }
            //获取库存，执行业务，库存减一
            Integer stock = Integer.parseInt(redisTemplate.opsForValue().get(productStockKey));
            if (stock > 0) {
                int realStock = stock - 1;
                redisTemplate.opsForValue().set(productStockKey, String.valueOf(realStock));
                log.info("购买成功！剩余库存: {}", realStock);
            } else {
                log.error("请求失败，库存不足！");
                return "请求失败，库存不足！";
            }
        } finally {
            if (clientId.equals(redisTemplate.opsForValue().get(lockName))) {
                redisTemplate.delete(lockName);
                log.warn("################################nx锁已释放！");
            }
        }

        return "success";
    }
}
