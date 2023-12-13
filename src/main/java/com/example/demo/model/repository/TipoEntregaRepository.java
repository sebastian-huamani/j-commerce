package com.example.demo.model.repository;

import com.example.demo.model.db.TipoEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEntregaRepository extends JpaRepository<TipoEntrega, Integer> {
}
