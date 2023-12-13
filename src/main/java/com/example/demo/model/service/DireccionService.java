package com.example.demo.model.service;


import com.example.demo.model.db.*;
import com.example.demo.model.repository.DepartamentoRepository;
import com.example.demo.model.repository.DireccionRepository;
import com.example.demo.model.repository.DistritoRepository;
import com.example.demo.model.repository.ProvinciaRepository;
import com.example.demo.model.request.PagoRequest;
import com.example.demo.model.response.RespuestaResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DireccionService {
    private DepartamentoRepository departamentoRepository;
    private ProvinciaRepository provinciaRepository;
    private DistritoRepository distritoRepository;
    private DireccionRepository direccionRepository;

    public List<Departamento> listarDepartamentos(){
        return departamentoRepository.findAll();
    }

    public List<Provincia> listarProvinciaPorDepartamento(Integer id){
        return provinciaRepository.findByDepartamentoId(id);
    }

    public List<Distrito> listarDistritoPorProvincia(Integer id){
        return distritoRepository.findByProvinciaId  (id);
    }


    public Direccion save(PagoRequest pagoRequest) {
        String msg = "Direccion Creado con Exito";
        Boolean status = true;

        Direccion direccion = null;
        try {
            direccion = new Direccion();
            if (pagoRequest.getId() > 0) {
                direccion.setId(pagoRequest.getId());
            }

            Optional<Departamento> departamento_db = departamentoRepository.findById(pagoRequest.getDepartamento());
            Departamento departamento = null;
            if (departamento_db.isPresent()) {
                departamento = departamento_db.get();
            } else {
                msg = "Producto no encontrado";
                status = false;
            }

            Optional<Provincia> provincia_db = provinciaRepository.findById(pagoRequest.getProvincia());
            Provincia provincia = null;
            if (provincia_db.isPresent()) {
                provincia = provincia_db.get();
            } else {
                msg = "Producto no encontrado";
                status = false;
            }

            Optional<Distrito> distrito_db = distritoRepository.findById(pagoRequest.getDistrito());
            Distrito distrito = null;
            if (distrito_db.isPresent()) {
                distrito = distrito_db.get();
            } else {
                msg = "Producto no encontrado";
                status = false;
            }

            direccion.setDepartamento(departamento);
            direccion.setProvincia(provincia);
            direccion.setDistrito(distrito);

            direccion.setDireccion(pagoRequest.getDireccion());
            direccion.setReferencias(pagoRequest.getReferencias());
            direccion.setCodigo_zip(pagoRequest.getCodigo_zip());
            direccion.setTelefono(pagoRequest.getTelefono());
                direccion.setDireccion_preferida(pagoRequest.getDireccion_preferida());
            direccionRepository.save(direccion);
        } catch (Exception exception) {
            msg = exception.getMessage();
            System.out.print(msg);
            status = false;
        }
        return direccion;
    }

}
