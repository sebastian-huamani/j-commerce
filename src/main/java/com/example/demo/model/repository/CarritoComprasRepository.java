package com.example.demo.model.repository;

import com.example.demo.model.db.CarritoCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarritoComprasRepository extends JpaRepository<CarritoCompras, Integer> {

    List<CarritoCompras> findByUsuarioId(Integer Id);

    @Procedure("eliminar_lista_carrito")
    void eliminarListaCarrito(Integer usuarioId);
}
