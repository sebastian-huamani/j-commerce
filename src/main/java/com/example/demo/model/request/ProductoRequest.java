package com.example.demo.model.request;


import lombok.Data;

@Data
public class ProductoRequest {
    private  Integer id;
    private  String nombre;
    private  String descripcion;
    private  String marca;
    private Integer precio_compra;
    private Integer precio_venta;
    private Boolean activo;
    private Integer cantidad;
    private Integer cantidad_minima;
}
