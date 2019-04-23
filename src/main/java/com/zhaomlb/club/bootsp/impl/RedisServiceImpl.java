package com.zhaomlb.club.bootsp.impl;

import com.zhaomlb.club.bootsp.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RedisServiceImpl implements RedisService {


    /**
     * Redis常见的五大数据类型
     * String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     * stringRedisTemplate.opsForValue()[操作String（字符串）]
     * stringRedisTemplate.opsForList()[操作List（列表）]
     * stringRedisTemplate.opsForSet()[操作Set（集合）]
     * stringRedisTemplate.opsForHash()[操作Hash（散列）]
     * stringRedisTemplate.opsForZSet()[操作ZSet（有序集合）]
     */
    @Autowired
    StringRedisTemplate redisTemplate;


    @Override
    public void saveStr(String key, String value) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().toString()).append(":");
        sb.append(key);
        redisTemplate.opsForValue().set(sb.toString(), value);
    }

    @Override
    public long GetIncre(String key) {
        RedisAtomicLong redisAtomicLong = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        return redisAtomicLong.getAndIncrement();
    }

    @Override
    public void listPush(String key, String value) {
        redisTemplate.opsForList().leftPush(key, value);
    }

    @Override
    public Object listPop(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    @Override
    public void hashSave(String key, String hk, String hv) {
        redisTemplate.opsForHash().put(key, hk, hv);
    }

    @Override
    public void setsave(String key, String... var2) {
        redisTemplate.opsForSet().add(key, var2);
    }

    @Override
    public Set<String> setintersect(String k1, String k2) {
        Set<String> stringSet = redisTemplate.opsForSet().difference(k1, k2);
        return stringSet;
    }

    @Override
    public void sortset(String key, String sk, double sd) {
        redisTemplate.opsForZSet().add(key, sk, sd);

    }

}
