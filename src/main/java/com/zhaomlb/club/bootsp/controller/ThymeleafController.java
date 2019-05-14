package com.zhaomlb.club.bootsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @RequestMapping("/index")
    public ModelAndView index() {

        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        view.addObject("title", "我的第一个WEB页面");
        view.addObject("desc", "我的第一个WEB页面");

        return view;
    }
    @GetMapping("/index1")
    public String index1(HttpServletRequest request) {
        // TODO 与上面的写法不同，但是结果一致。
        // 设置属性
        request.setAttribute("title", "我的第一个WEB页面");
        request.setAttribute("desc", "欢迎进入battcn-web 系统");

        // 返回的 index 默认映射到 src/main/resources/templates/xxxx.html
        return "/index";
    }

}
