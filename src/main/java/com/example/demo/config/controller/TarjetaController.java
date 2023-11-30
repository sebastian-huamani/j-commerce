package com.example.demo.config.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/tarjetas")
public class TarjetaController {

    @GetMapping("/")
    public String index(){
        return "/tarjetas/index";
    }
}
