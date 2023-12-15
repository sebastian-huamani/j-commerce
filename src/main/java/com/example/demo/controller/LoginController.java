package com.example.demo.controller;

import com.example.demo.model.request.security.UsuarioSecurity;
import com.example.demo.model.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
@Controller
@AllArgsConstructor
public class LoginController {
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login(){
        return "/auth/frmLogin";
    }

    @GetMapping("/login-success")
    public String loginSuccess(){
        return "redirect:/productos";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request){
        HttpSession session =  request.getSession();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UsuarioSecurity usuarioSecurity = (UsuarioSecurity) userDetails;

        session.setAttribute("usuario", usuarioSecurity);
        session.setAttribute("usuario_2", userDetails.getAuthorities());
        System.out.println(userDetails.getAuthorities());
        return "homeloged";
    }

}

