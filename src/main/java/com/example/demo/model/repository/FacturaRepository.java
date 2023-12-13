package com.example.demo.model.repository;

import com.example.demo.model.db.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {

    @Procedure("actualizar_total_factura")
    void actualizarTotalFactura(Integer factura_id);
}
