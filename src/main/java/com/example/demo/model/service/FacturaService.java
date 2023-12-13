package com.example.demo.model.service;

import com.example.demo.model.db.Entrega;
import com.example.demo.model.db.Factura;
import com.example.demo.model.db.TipoPago;
import com.example.demo.model.db.Usuario;
import com.example.demo.model.repository.FacturaRepository;
import com.example.demo.model.repository.TipoPagoRepository;
import com.example.demo.model.repository.UsuarioRepository;
import com.example.demo.model.request.PagoRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FacturaService {

    private UsuarioRepository usuarioRepository;
    private TipoPagoRepository tipoPagoRepository;
    private FacturaRepository facturaRepository;

    public List<Factura> listar(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario =  usuarioRepository.findByNombres(String.valueOf(auth.getName()));

        return facturaRepository.findByUsuarioId(usuario.getId());
    }

    public void actualizarTotalFactura(Integer factura_id){
        facturaRepository.actualizarTotalFactura(factura_id);
    }

    public Factura save(PagoRequest pagoRequest, Entrega entrega){
        String msg = "Entrega Creado con Exito";
        Boolean status = true;

        Factura factura = null;
        try{
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Usuario usuario =  usuarioRepository.findByNombres(String.valueOf(auth.getName()));

            factura = new Factura();
            if (pagoRequest.getId() > 0) {
                factura.setId(pagoRequest.getId());
            }

            Optional<TipoPago> tipoPago_db = tipoPagoRepository.findById(pagoRequest.getTipoPago());
            TipoPago tipoPago = null;
            if (tipoPago_db.isPresent()) {
                tipoPago = tipoPago_db.get();
            } else {
                msg = "El Tipo Entrega ha generado un error";
                status = false;
            }

            factura.setTipoPago(tipoPago);
            factura.setEntrega(entrega);
            factura.setUsuario(usuario);
            factura.setEntregado(false);
            factura.setCosto_delivery(pagoRequest.getCosto_delivery());
            facturaRepository.save(factura);

        }catch (Exception exception){
            msg = exception.getMessage();
            System.out.print(msg);
            status = false;
        }

        return factura;
    }
}
