package com.example.demo.controller;

import com.example.demo.model.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/monitoreo")
public class MonitoreoProductosController {

    private ProductoService productoService;

    @GetMapping("/listar")
    public String productosListar(Model model){
        model.addAttribute("productos", productoService.listarProductos());
        return "/monitoreo/productos";
    }


}


