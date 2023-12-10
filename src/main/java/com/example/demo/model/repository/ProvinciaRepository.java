package com.example.demo.model.repository;

import com.example.demo.model.db.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {
    List<Provincia> findByDepartamentoId(Integer id);
}
