package com.example.demo.model.request;

import com.example.demo.model.db.*;
import lombok.Data;

@Data
public class PagoRequest {
    private Integer id;
    private Integer departamento;
    private Integer provincia;
    private Integer distrito;
    private String direccion;
    private String referencias;
    private String codigo_zip;
    private Boolean direccion_preferida;
    private Integer telefono;

    private Integer tipoEntrega;
    private Integer tipoPago;

    private Double costo_delivery;
}
