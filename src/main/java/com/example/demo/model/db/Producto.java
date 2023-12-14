package com.example.demo.model.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private  String nombre;

    @Column(name = "descripcion")
    private  String descripcion;

    @Column(name = "marca")
    private  String marca;

    @Column(name = "precio_compra")
    private Double precio_compra;

    @Column(name = "precio_venta")
    private Double precio_venta;

    @Column(name = "activo")
    private Boolean activo;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "cantidad_minima")
    private Integer cantidad_minima;

}
