package com.example.demo.controller;

import com.example.demo.model.service.FacturaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/monitoreo/entregas")
public class MonitoreoEntergas {

    private FacturaService facturaService;

    @GetMapping("/listar")
    public String index(Model model){
        System.out.println(facturaService.listarAll() );
        model.addAttribute("pedidos", facturaService.listarAll() );
        return "/monitoreo/entregas";
    }

    @GetMapping("/estado/aceptado/{id}")
    public void denegado(@PathVariable int id, Model model){
        try {
            facturaService.actualizarEstadoEntrega(id, 1);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @GetMapping("/estado/denegado/{id}")
    public void entregado(@PathVariable int id, Model model) {
        try{
            facturaService.actualizarEstadoEntrega(id, 2);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
