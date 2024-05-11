package com.hiring.devs.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protected")
public class TestController {

    @GetMapping
    public String testSecurity(){
        return "hola mundo from protected method";
    }
}
