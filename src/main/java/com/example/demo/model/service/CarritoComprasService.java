package com.example.demo.model.service;

import com.example.demo.model.db.CarritoCompras;
import com.example.demo.model.db.Producto;
import com.example.demo.model.db.Usuario;
import com.example.demo.model.repository.CarritoComprasRepository;
import com.example.demo.model.repository.ProductoRepository;
import com.example.demo.model.repository.UsuarioRepository;
import com.example.demo.model.request.CarritoComprasRequest;
import com.example.demo.model.response.RespuestaResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class CarritoComprasService {
    private CarritoComprasRepository carritoComprasRepository;
    private UsuarioRepository usuarioRepository;
    private ProductoRepository productoRepository;

    public RespuestaResponse agregar(CarritoComprasRequest carritoComprasRequest){
        String msg = "Pruebas";
        Boolean status = true;
        try{
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Usuario usuario =  usuarioRepository.findByNombres(String.valueOf(auth.getName()));

            Optional<Producto> producto_db = productoRepository.findById(carritoComprasRequest.getId());
            Producto producto = null;
            if (producto_db.isPresent()) {
                producto = producto_db.get();
            } else {
                msg = "Producto no encontrado";
                status = false;
                return RespuestaResponse.builder().mensaje(msg).respuesta(status).build();
            }

            CarritoCompras carritoCompras = new CarritoCompras();
            carritoCompras.setUsuario(usuario);
            carritoCompras.setProducto(producto);
            carritoCompras.setCantidad(carritoComprasRequest.getCantidad());
            carritoCompras.setActivo(true);
            carritoComprasRepository.save(carritoCompras);
        } catch (Exception exception){
            msg = exception.getMessage();
            status = false;
        }

        return RespuestaResponse.builder().mensaje(msg).respuesta(status).build();
    }
}
