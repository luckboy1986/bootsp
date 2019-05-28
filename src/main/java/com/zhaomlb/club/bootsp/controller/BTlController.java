package com.zhaomlb.club.bootsp.controller;

import com.zhaomlb.club.bootsp.entity.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/btl")
public class BTlController {

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("add request");
        UserDto userDto = new UserDto();
        userDto.setUsrNmae("zhaomlb");
        userDto.setUsrCode("psd");

        modelAndView.addObject("userDto", userDto);
        modelAndView.setViewName("add");
        return modelAndView;

    }

    @GetMapping("/index")
    public String indx() {
        return "add";
    }
}
