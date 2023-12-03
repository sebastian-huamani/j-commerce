package com.example.demo.config.controller;

import com.example.demo.model.db.Producto;
import com.example.demo.model.db.Usuario;
import com.example.demo.model.repository.ProductoRepository;
import com.example.demo.model.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/productos")
public class ProductosController {

    private ProductoService productoService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("productos", productoService.listarProductos()   );
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


}
