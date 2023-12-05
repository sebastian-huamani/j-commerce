package com.example.demo.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespuestaResponse {
    private Boolean respuesta;
    private String mensaje;
}
