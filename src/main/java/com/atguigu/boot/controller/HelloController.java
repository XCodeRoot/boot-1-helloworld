package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody//表示方法返回的字符串 是直接返回给浏览器,而不是作为逻辑视图,进行跳转

@Slf4j
@RestController // 相当于@Controller 和 @ResponseBody
public class HelloController {

    @Autowired
    Car car; // 使用properties文件里的默认配置


    @RequestMapping("/car")
    public Car car(){
        return car;
    }


    @RequestMapping("/hello")
    public String handle01(){
        log.info("这是slf4j的日志功能");
        return "hello,Spring Boot 2.3.4"+"你好";
    }
}
