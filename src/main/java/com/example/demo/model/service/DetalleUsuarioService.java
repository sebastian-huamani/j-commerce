package com.example.demo.model.service;

import com.example.demo.model.db.Rol;
import com.example.demo.model.db.Usuario;
import com.example.demo.model.security.UsuarioSecurity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class DetalleUsuarioService implements UserDetailsService {
    private UsuarioService usuarioService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.findUserByUserEmail(username);

        return autenticacionUsuario(usuario, obtenerListaRolesxUsuario(usuario.getRoles()));
    }

    private List<GrantedAuthority> obtenerListaRolesxUsuario(Set<Rol> listRoles){
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Rol rol : listRoles){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return  grantedAuthorities;
    }

    private UsuarioSecurity autenticacionUsuario(Usuario usuario, List<GrantedAuthority> authorities){
        UsuarioSecurity usuarioSecurity = new UsuarioSecurity(
                usuario.getNombres(),
                usuario.getPassword(),
                usuario.getActivo(),
                true,
                true,
                true,
                authorities
        );
        usuarioSecurity.setEmail(usuario.getEmail());
        usuarioSecurity.setApellido_paterno(usuario.getApellido_paterno());
        usuarioSecurity.setApellido_materno(usuario.getApellido_materno());
        return usuarioSecurity;
    }
}
