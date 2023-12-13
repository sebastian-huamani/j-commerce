package com.example.demo.model.repository;

import com.example.demo.model.db.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {

    List<Factura> findByUsuarioId(Integer Id);

    @Procedure("actualizar_total_factura")
    void actualizarTotalFactura(Integer factura_id);
}
