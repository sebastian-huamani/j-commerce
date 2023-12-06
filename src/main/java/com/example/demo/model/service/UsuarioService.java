package com.example.demo.model.service;

import com.example.demo.model.db.Rol;
import com.example.demo.model.db.Usuario;
import com.example.demo.model.repository.RolRepository;
import com.example.demo.model.repository.UsuarioRepository;
import com.example.demo.model.request.UsuarioRequest;
import com.example.demo.model.response.RespuestaResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public Optional<Usuario> findUserById(int id){ return usuarioRepository.findById(id); }

    public Usuario findUserByUserEmail(String email){
        return  usuarioRepository.findByEmail(email);
    }

    public Usuario findUserByUserNombres(String nombre){
        return usuarioRepository.findByNombres(nombre);
    }

    public  Usuario guardarUsuario(Usuario usuario){
        Rol userRol = rolRepository.findByNombre("ADMIN");
        usuario.setRoles(new HashSet<>(Arrays.asList(userRol)));
        usuario.setNombres(usuario.getNombres());
        usuario.setApellido_paterno(usuario.getApellido_paterno());
        usuario.setApellido_materno(usuario.getApellido_materno());
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        usuario.setEmail(usuario.getEmail());
        usuario.setActivo(true);
        return usuarioRepository.save(usuario);
    }


    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }


}
