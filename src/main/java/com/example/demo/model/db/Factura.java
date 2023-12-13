package com.example.demo.model.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tipo_pago_id")
    private  TipoPago tipoPago;

    @ManyToOne
    @JoinColumn(name = "entrega_id")
    private  Entrega entrega;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private  Usuario usuario;

    @Column(name = "costo_delivery")
    private Double costo_delivery;

}
