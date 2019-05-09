package com.zhaomlb.club.bootsp.controller;

import com.zhaomlb.club.bootsp.entity.LogDto;
import com.zhaomlb.club.bootsp.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @ResponseBody
    public LogDto savewithParms(@RequestHeader String name) throws Exception {
        LogDto logDto = new LogDto();
        logDto.setClsName(String.valueOf(System.currentTimeMillis()));
        logDto.setMethod(String.valueOf(System.currentTimeMillis()));
        throw  new Exception("我的错误");

    }
}
