package com.example.demo.controller;

import com.example.demo.model.db.Detalle;
import com.example.demo.model.response.UsuarioResponse;
import com.example.demo.model.service.DetalleService;
import com.example.demo.model.service.FacturaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/factura")
public class FacturaController {

    private FacturaService facturaService;
    private DetalleService detalleService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("facturas", facturaService.listar());
        return "/facturas/index";
    }

    @GetMapping("/detalle/{id}")
    public List<Detalle> detalle(@PathVariable int id, Model model) {
        List<Detalle> detalle = null;
        try {
            detalle = detalleService.listarDetalleByFactura(id);
            System.out.println(detalle);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


//        model.addAttribute("producto", producto);
//        return "/productos/editar";
        return detalle;
    }
}
