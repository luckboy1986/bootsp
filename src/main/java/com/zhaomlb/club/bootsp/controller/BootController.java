package com.zhaomlb.club.bootsp.controller;

import com.google.gson.Gson;
import com.zhaomlb.club.bootsp.config.Myconfig;
import com.zhaomlb.club.bootsp.entity.UserDto;
import com.zhaomlb.club.bootsp.service.RedisService;
import com.zhaomlb.club.bootsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/bootsp")
public class BootController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private Gson gson;

    @RequestMapping("/test")
    public List<UserDto> test() {
        return userService.getUserList();
    }

    @RequestMapping("/save")
    @ResponseBody
    public UserDto save(@RequestParam String data) {
        UserDto userDto=  gson.fromJson(data,UserDto.class);
        return userService.insert(userDto);
    }

    @RequestMapping("redis/save")
    @ResponseBody
    public UserDto redissave(@RequestParam String usrNmae, @RequestParam String usrCode) {
        redisService.saveStr(String.valueOf(System.currentTimeMillis()), "1111");
        return null;
    }

    @RequestMapping("redis/incre")
    public long redisincre(@RequestParam String key) {
        return redisService.GetIncre(key);
    }

    @RequestMapping("redis/listPush")
    public void listPush(@RequestParam String key, @RequestParam String value) {
        redisService.listPush(key, value);
    }

    @RequestMapping("redis/listPop")
    public Object listPop(@RequestParam String key) {
        return redisService.listPop(key);
    }

    @RequestMapping("redis/hashSave")
    public void hashSave(@RequestParam String key, @RequestParam String hk, @RequestParam String hv) {
        redisService.hashSave(key, hk, hv);
    }

    @RequestMapping("redis/setsave")
    public void setsave(@RequestParam String key, @RequestParam String k1, @RequestParam String k2) {
        redisService.setsave(key, k1, k2);
    }

    @RequestMapping("redis/setsavetest")
    public void setsavetest(@RequestParam String key, @RequestParam int num) {
        for (int i = 0; i < num; i++) {
            redisService.setsave(key, String.valueOf(i));
        }

    }

    @RequestMapping("redis/setintersect")
    public Set<String> setintersect(@RequestParam String k1, @RequestParam String k2) {
        return redisService.setintersect(k1, k2);
    }

    @RequestMapping("redis/sortset")
    public void sortset(@RequestParam String key, @RequestParam String k1, @RequestParam double sd) {
        redisService.sortset(key, k1, sd);
    }

    @RequestMapping("redis/bittst")
    public void bittst(@RequestParam int num) {
        for (int i = 0; i < num; i++) {
            redisService.bitCount(Long.valueOf(i));
        }
    }

    @RequestMapping("redis/bitGet")
    public boolean bitGet(@RequestParam int num) {
        return redisService.bitGet(Long.valueOf(num));
    }

    @RequestMapping("redis/bitCountGet")
    public String bitCountGet(@RequestParam int num) {
        return redisService.bitCountGet(Long.valueOf(num));
    }

    @Autowired
    private Myconfig myconfig;

    @RequestMapping("config/getconfig")
    public String getconfig() {
        return myconfig.toString();
    }
}
