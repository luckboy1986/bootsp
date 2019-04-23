package com.zhaomlb.club.bootsp.service;

import java.util.Set;

public interface RedisService {
    void saveStr(String key, String value);

    long GetIncre(String key);

    void listPush(String key, String value);

    Object listPop(String key);

    void hashSave(String key,String hk,String hv);

    void setsave(String key,String... var2);

    Set<String> setintersect(String k1, String k2);

    void sortset(String key, String sk,double sd);
}
