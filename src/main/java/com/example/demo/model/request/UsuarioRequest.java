package com.example.demo.model.request;


import lombok.Data;

@Data
public class UsuarioRequest {
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String email;
    private String documento;

}
