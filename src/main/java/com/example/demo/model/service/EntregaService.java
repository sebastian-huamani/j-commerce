package com.example.demo.model.service;

import com.example.demo.model.db.*;
import com.example.demo.model.repository.DireccionRepository;
import com.example.demo.model.repository.EntregaRepository;
import com.example.demo.model.repository.TipoEntregaRepository;
import com.example.demo.model.repository.UsuarioRepository;
import com.example.demo.model.request.PagoRequest;
import com.example.demo.model.response.RespuestaResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EntregaService {

    private DireccionRepository direccionRepository;
    private UsuarioRepository usuarioRepository;
    private TipoEntregaRepository tipoEntregaRepository;
    private EntregaRepository entregaRepository;

    public Entrega save(PagoRequest pagoRequest, Direccion direccion){
        String msg = "Entrega Creado con Exito";
        Boolean status = true;

        Entrega entrega = null;
        try{

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Usuario usuario =  usuarioRepository.findByNombres(String.valueOf(auth.getName()));


            Optional<TipoEntrega> tipoEntrega_db = tipoEntregaRepository.findById(pagoRequest.getTipoEntrega());

            TipoEntrega tipoEntrega = null;
            if (tipoEntrega_db.isPresent()) {
                tipoEntrega = tipoEntrega_db.get();
            } else {
                msg = "El Tipo Entrega ha generado un error";
                status = false;
            }
            entrega = new Entrega();
            entrega.setTipoEntrega(tipoEntrega);
            entrega.setUsuario(usuario);
            entrega.setDireccion(direccion);
            entregaRepository.save(entrega);

        }catch (Exception exception){
            msg = exception.getMessage();
            System.out.print("here");
            System.out.print(msg);
            status = false;
        }
        return entrega;
    }
}
