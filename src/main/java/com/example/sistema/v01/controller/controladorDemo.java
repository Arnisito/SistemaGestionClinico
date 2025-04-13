package com.example.sistema.v01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/demo")
public class controladorDemo {
    @PostMapping("/v1")
    public String postMethodName() {
        return "welcome";
    }
}
