package com.example.demo.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioResponse {
    private Boolean respuesta;
    private String mensaje;
}
