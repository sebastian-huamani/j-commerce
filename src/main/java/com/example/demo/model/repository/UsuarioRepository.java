package com.example.demo.model.repository;

import com.example.demo.model.db.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {

    Usuario findByEmail(String email);

    Usuario findByNombres(String nombres);
}
