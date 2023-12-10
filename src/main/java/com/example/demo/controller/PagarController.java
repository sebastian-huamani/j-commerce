package com.example.demo.controller;


import com.example.demo.model.db.Distrito;
import com.example.demo.model.db.Provincia;
import com.example.demo.model.service.CarritoComprasService;
import com.example.demo.model.service.DireccionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/pagar")
public class PagarController {

    private DireccionService direccionService;
    private CarritoComprasService carritoComprasService;

    @GetMapping("/")
    public String pagar(Model model){
        model.addAttribute("productos", carritoComprasService.listar());
        model.addAttribute("total", carritoComprasService.calcular());
        model.addAttribute("departamentos", direccionService.listarDepartamentos());
        return "/carrito/completarPago";
    }

    @GetMapping("/provincias/{id}")
    @ResponseBody
    public List<Provincia> listarProvincias(@PathVariable int id, Model model){
        return direccionService.listarProvinciaPorDepartamento(id);
    }

    @GetMapping("/distrito/{id}")
    @ResponseBody
    public List<Distrito> listarDistrito(@PathVariable int id, Model model){
        return direccionService.listarDistritoPorProvincia(id);
    }


}
