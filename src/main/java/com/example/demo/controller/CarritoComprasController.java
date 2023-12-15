package com.example.demo.controller;


import com.example.demo.model.db.CarritoCompras;
import com.example.demo.model.db.Producto;
import com.example.demo.model.db.Usuario;
import com.example.demo.model.repository.CarritoComprasRepository;
import com.example.demo.model.request.CarritoComprasRequest;
import com.example.demo.model.response.RespuestaResponse;
import com.example.demo.model.service.CarritoComprasService;
import com.example.demo.model.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/carrito/compras")
public class CarritoComprasController {

    private CarritoComprasService carritoComprasService;
    private UsuarioService usuarioService;

    @PostMapping("/agregar")
    @ResponseBody
    public RespuestaResponse agregar(@RequestBody CarritoComprasRequest carritoComprasRequest){
        return carritoComprasService.agregar(carritoComprasRequest);
    }

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("productos", carritoComprasService.listar());
        model.addAttribute("total", carritoComprasService.calcular());
        return "/carrito/listaCarrito";
    }

    @GetMapping("/eliminar/{id}")
    public void listar(@PathVariable int id, Model model){
        carritoComprasService.deleteProductoCarrito(id);
    }

}
