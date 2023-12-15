package com.example.demo.controller;

import com.example.demo.model.db.Producto;
import com.example.demo.model.db.Rol;
import com.example.demo.model.db.Usuario;
import com.example.demo.model.repository.UsuarioRepository;
import com.example.demo.model.request.ProductoRequest;
import com.example.demo.model.response.RespuestaResponse;
import com.example.demo.model.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/productos")
public class ProductosController {

    private ProductoService productoService;
    private UsuarioRepository usuarioRepository;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("productos", productoService.listarProductos());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario =  usuarioRepository.findByNombres(String.valueOf(auth.getName()));
        System.out.println( usuario.getRoles());

        model.addAttribute("usuario", usuario);
        return "/productos/index";
    }

    @GetMapping("/visualizar/{id}")
    public String vizualizar(@PathVariable int id, Model model){
        Optional<Producto> db_producto = productoService.findProductoById(id);

        Producto producto = null;
        if (db_producto.isPresent()) {
            producto = db_producto.get();
        } else {
            model.addAttribute("mensaje_error", "Usuario no Encontrado");
            return "error";
        }

        model.addAttribute("producto", producto);
        return "/productos/producto";
    }

    @GetMapping("/crear")
    public String crear(){
        return "/productos/crear";
    }

    @PostMapping("/store")
    @ResponseBody
    public RespuestaResponse store(@RequestBody ProductoRequest productoRequest){
         return productoService.save(productoRequest);
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Producto> db_producto = productoService.findProductoById(id);

        Producto producto = null;
        if (db_producto.isPresent()) {
            producto = db_producto.get();
        } else {
            model.addAttribute("mensaje_error", "Producto no Encontrado");
            return "error";
        }

        model.addAttribute("producto", producto);
        return "/productos/editar";
    }

}
