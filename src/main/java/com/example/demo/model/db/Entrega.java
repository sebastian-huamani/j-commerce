package com.example.demo.model.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@Table(name = "entrega")
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tipo_entrega_id")
    private  TipoEntrega tipoEntrega;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private  Usuario usuario ;

    @ManyToOne
    @JoinColumn(name = "direccion_id")
    private  Direccion direccion;
}
