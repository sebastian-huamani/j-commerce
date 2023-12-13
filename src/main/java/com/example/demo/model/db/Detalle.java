package com.example.demo.model.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "detalle")
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private  Producto producto;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private  Factura factura;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "subtotal")
    private Double subtotal;

}
