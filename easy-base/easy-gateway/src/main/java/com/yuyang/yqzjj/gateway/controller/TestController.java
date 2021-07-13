package com.yuyang.easy.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author yuyang
 * @date 2020/11/9 20:11
 * @Description
 */
@RestController
public class TestController {
    @Value("${spring.mvc.locale}")
    String value;
    @RequestMapping("test")
    public String test(){
        System.out.println("======================进入了test");
        return value;
    }
}
