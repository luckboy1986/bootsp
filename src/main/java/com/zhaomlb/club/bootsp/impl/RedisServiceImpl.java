package com.zhaomlb.club.bootsp.impl;

import com.zhaomlb.club.bootsp.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import org.springframework.stereotype.Service;

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
    public void save(String key, String value) {

        StringBuilder sb = new StringBuilder();
       ;
        sb.append( this.getClass().toString().replace('.',':')).append(":");
     /*   sb.append(this.getClass().getSimpleName());
        sb.append('.').append(this.getClass().getName()).append(":");*/
        sb.append(key);
        redisTemplate.opsForValue().set(sb.toString(), value);
    }

    public void savelist(String key, String value) {
        //redisTemplate.opsForList().s(key, value);
    }
}
