package com.example.demo.controller;

import com.example.demo.model.request.ProductoRequest;
import com.example.demo.model.request.UsuarioRequest;
import com.example.demo.model.db.Usuario;
import com.example.demo.model.response.RespuestaResponse;
import com.example.demo.model.response.UsuarioResponse;
import com.example.demo.model.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuariosController {
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "/usuario/index";
    }

    @GetMapping("/perfil")
    public String verPerfil(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Usuario usuario =  usuarioService.findUserByUserNombres(String.valueOf(auth.getName()));
        model.addAttribute("usuario", usuarioService.findUserByUserNombres(String.valueOf(auth.getName())));
        return "/usuario/miPerfil";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Usuario> db_usuario = usuarioService.findUserById(id);

        Usuario usuario = null;
        if (db_usuario.isPresent()) {
            usuario = db_usuario.get();
        } else {
            model.addAttribute("mensaje_error", "Usuario no Encontrado");
            return "error";
        }

        model.addAttribute("usuario", usuario);
        return "/usuario/editar";
    }



}
