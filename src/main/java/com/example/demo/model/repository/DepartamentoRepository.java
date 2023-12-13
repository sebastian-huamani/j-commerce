package com.example.demo.model.repository;

import com.example.demo.model.db.CarritoCompras;
import com.example.demo.model.db.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
}
