package com.example.demo.model.repository;

import com.example.demo.model.db.Usuario;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {

    Usuario findByEmail(String email);

    Usuario findById(Id id);

    Usuario findByNombres(String nombres);
}
