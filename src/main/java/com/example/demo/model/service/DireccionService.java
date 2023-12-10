package com.example.demo.model.service;


import com.example.demo.model.db.Departamento;
import com.example.demo.model.db.Distrito;
import com.example.demo.model.db.Provincia;
import com.example.demo.model.repository.DepartamentoRepository;
import com.example.demo.model.repository.DistritoRepository;
import com.example.demo.model.repository.ProvinciaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DireccionService {
    private DepartamentoRepository departamentoRepository;
    private ProvinciaRepository provinciaRepository;
    private DistritoRepository distritoRepository;

    public List<Departamento> listarDepartamentos(){
        return departamentoRepository.findAll();
    }

    public List<Provincia> listarProvinciaPorDepartamento(Integer id){
        return provinciaRepository.findByDepartamentoId(id);
    }

    public List<Distrito> listarDistritoPorProvincia(Integer id){
        return distritoRepository.findByProvinciaId  (id);
    }

}
