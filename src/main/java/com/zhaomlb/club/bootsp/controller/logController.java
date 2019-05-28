package com.zhaomlb.club.bootsp.controller;

import com.zhaomlb.club.bootsp.entity.LogDto;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/log")
@ResponseBody
public class logController {


    @RequestMapping("/save")
    @ResponseBody
    public LogDto save() {
        LogDto logDto = new LogDto();
        logDto.setClsName(String.valueOf(System.currentTimeMillis()));
        logDto.setMethod(String.valueOf(System.currentTimeMillis()));
        return logDto;
    }

    @RequestMapping("/savewithParms")
    public LogDto savewithParms(@RequestParam String name) throws Exception {
        LogDto logDto = new LogDto();
        logDto.setClsName(String.valueOf(System.currentTimeMillis()));
        logDto.setMethod(String.valueOf(System.currentTimeMillis()));
        //throw  new Exception("我的错误");
        return logDto;
    }
}
