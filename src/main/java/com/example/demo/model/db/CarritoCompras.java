package com.example.demo.model.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "lista_carrito")
public class CarritoCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private  Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "producto_id ")
    private  Producto producto;

    @Column(name = "activo")
    private Boolean activo;

    @Column(name = "cantidad")
    private Integer cantidad;

}
