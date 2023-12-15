package com.example.demo.model.service;

import com.example.demo.model.db.Producto;
import com.example.demo.model.repository.ProductoRepository;
import com.example.demo.model.request.ProductoRequest;
import com.example.demo.model.response.RespuestaResponse;
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

    public RespuestaResponse save(ProductoRequest productoRequest){
        String msg = "Producto Creado con Exito";
        Boolean status = true;

        try{
            Producto producto = new Producto();
            if(productoRequest.getId() > 0 ){
                producto.setId(productoRequest.getId());
            }
            producto.setNombre(productoRequest.getNombre());
            producto.setDescripcion(productoRequest.getDescripcion());
            producto.setMarca(productoRequest.getMarca());
            producto.setPrecio_compra(Double.valueOf(productoRequest.getPrecio_compra()));
            producto.setPrecio_venta(Double.valueOf(productoRequest.getPrecio_venta()));
            producto.setActivo(productoRequest.getActivo());
            producto.setCantidad(productoRequest.getCantidad());
            producto.setCantidad_minima(productoRequest.getCantidad_minima());
            productoRepository.save(producto);
        } catch (Exception exception){
            msg = exception.getMessage();
            status = false;
        }
        return RespuestaResponse.builder().mensaje(msg).respuesta(status).build();

    }


}
