package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/transacciones")
public class TransaccionesController {

    @GetMapping("/")
    public String index(){
        return "/transacciones/index";
    }
}
