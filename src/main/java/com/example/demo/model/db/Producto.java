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
    private Float precio_compra;

    @Column(name = "precio_venta")
    private Float precio_venta;
}
