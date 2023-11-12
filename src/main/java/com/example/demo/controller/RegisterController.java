package com.example.demo.controller;

import com.example.demo.model.db.Usuario;
import com.example.demo.model.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/auth")

public class RegisterController {
    private UsuarioService usuarioService;

    @GetMapping("/register")
    public String register(){
        return "/auth/frmRegister";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Usuario usuario){
        usuarioService.guardarUsuario(usuario);
        return "/auth/frmLogin";
    }
}
