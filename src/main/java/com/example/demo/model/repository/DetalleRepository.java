package com.example.demo.model.repository;

import com.example.demo.model.db.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Integer> {
    List<Detalle> findByFacturaId(Integer id);
}
