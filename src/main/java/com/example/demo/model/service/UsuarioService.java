package com.example.demo.model.service;

import com.example.demo.model.db.Rol;
import com.example.demo.model.db.Usuario;
import com.example.demo.model.repository.RolRepository;
import com.example.demo.model.repository.UsuarioRepository;
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
//        usuario.setDocumento(usuario.getDocumento());
        usuario.setActivo(true);
//        usuario.setFecha_nacimiento(usuario.getFecha_nacimiento());
//        usuario.setFecha_creacion(usuario.getFecha_creacion());
//        usuario.setFecha_actualizacion(usuario.getFecha_actualizacion());
        return usuarioRepository.save(usuario);
    }


    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

//    public Usuario editarUsuario(Usuario usuario){
//        return  "";
//    }

}
