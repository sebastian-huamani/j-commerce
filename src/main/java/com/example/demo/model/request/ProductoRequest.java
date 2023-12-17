package com.example.demo.model.request;


import lombok.Data;

@Data
public class ProductoRequest {
    private  Integer id;
    private  String nombre;
    private  String descripcion;
    private  String marca;
    private Double precio_compra;
    private Double precio_venta;
    private Boolean activo;
    private Integer cantidad;
    private Integer cantidad_minima;
    private String imagen_url;
}
