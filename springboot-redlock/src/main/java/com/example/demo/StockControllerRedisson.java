package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author wangzy
 * @date 2020年11月18日
 * 使用Redisson实现分布式锁
 */
@Slf4j
@RestController
public class StockControllerRedisson {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedissonClient redissonClient;


    @GetMapping("/sale")
    public String saleProduct() {
        //产品库存在Redis中的键
        String productStockKey = "prod:AE3012:stock";
        //nx锁
        String lockName = "prod:lock";

        RLock lock = redissonClient.getLock(lockName);
        try {
            //设置redisson锁
            lock.lock();
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
            lock.unlock();
            log.warn("################################nx锁已释放！");
        }

        return "success";
    }
}
