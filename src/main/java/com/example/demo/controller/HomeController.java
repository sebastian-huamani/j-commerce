package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/index")
    public String index2(){
        System.out.print("asd");
        return "home2";
    }

}
