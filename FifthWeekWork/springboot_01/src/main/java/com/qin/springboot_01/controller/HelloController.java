package com.qin.springboot_01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("helloSpring")
    public String handle01(){
        return "<h1 align='center'>helloSpring!</h1>";
    }
}
