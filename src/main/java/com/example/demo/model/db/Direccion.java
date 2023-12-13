package com.example.demo.model.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "direcciones")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private  Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "provincia_id")
    private  Provincia provincia;

    @ManyToOne
    @JoinColumn(name = "distrito_id")
    private  Distrito distrito;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "referencias")
    private String referencias;

    @Column(name = "codigo_zip")
    private String codigo_zip;

    @Column(name = "direccion_preferida")
    private Boolean direccion_preferida;

    @Column(name = "telefono")
    private Integer telefono;
}
