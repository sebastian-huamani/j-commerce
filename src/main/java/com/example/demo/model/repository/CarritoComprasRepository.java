package com.example.demo.model.repository;

import com.example.demo.model.db.CarritoCompras;
import com.example.demo.model.db.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoComprasRepository extends JpaRepository<CarritoCompras, Integer> {
}
