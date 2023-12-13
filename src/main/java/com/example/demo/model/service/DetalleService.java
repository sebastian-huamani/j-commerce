package com.example.demo.model.service;

import com.example.demo.model.db.*;
import com.example.demo.model.repository.DetalleRepository;
import com.example.demo.model.repository.ProductoRepository;
import com.example.demo.model.response.RespuestaResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DetalleService {
    private DetalleRepository detalleRepository;
    private CarritoComprasService carritoComprasService;
    private ProductoRepository productoRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public RespuestaResponse saveDetalleProductos(Factura factura){
        String msg = "Compra Procesada con Exito";
        Boolean status = true;

        List<CarritoCompras> carritoCompras = carritoComprasService.listar();
        Detalle detalle = null;

        try{
            for (CarritoCompras carritoItem : carritoCompras){
                detalle = new Detalle();

                Optional<Producto> producto_db = productoRepository.findById(carritoItem.getId());
                Producto producto = null;
                if (producto_db.isPresent()) {
                    producto = producto_db.get();
                } else {
                    msg = "Producto no encontrado";
                    status = false;
                }

                detalle.setProducto(producto);
                detalle.setFactura(factura);
                detalle.setCantidad(carritoItem.getCantidad());
                detalle.setPrecio(Double.valueOf(producto.getPrecio_venta()));

                Double subTotal = Double.valueOf(producto.getPrecio_venta()) * carritoItem.getCantidad();
                detalle.setSubtotal(subTotal);
                detalleRepository.save(detalle);
            }
        }catch (Exception exception){
            msg = exception.getMessage();
            status = false;
        }

        return RespuestaResponse.builder().mensaje(msg).respuesta(status).build();
    }



}
