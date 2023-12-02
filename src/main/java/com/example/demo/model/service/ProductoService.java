package com.example.demo.model.service;

import com.example.demo.model.db.Producto;
import com.example.demo.model.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoService {
    private ProductoRepository productoRepository;

    public Optional<Producto> findProductoById(int id){
        return productoRepository.findById(id);
    }

    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }
}
