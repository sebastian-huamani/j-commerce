package com.example.demo.config;

import com.example.demo.model.service.DetalleUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    private  final DetalleUsuarioService detalleUsuarioService;

    @Bean
    public SecurityFilterChain config(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeHttpRequests(
                        auth->
                                auth.requestMatchers(
                                            "/auth/login",
                                        "/auth/login",
                                        "/auth/register",
                                        "/auth/register",
                                        "/resources/**",
                                        "/static/**",
                                        "/styles/**",
                                        "/scripts/**")
                                        .permitAll()
                                        .anyRequest()
                                        .authenticated()
                ).formLogin(
                        login ->
                                login.loginPage("/auth/login")
                                    .defaultSuccessUrl("/auth/login-success")
                                    .usernameParameter("nombres")
                                        .passwordParameter("password")
                ).logout(
                        logout ->
                                logout.logoutSuccessUrl("/auth/login")
                                        .invalidateHttpSession(true)

                ).authenticationProvider(authenticationProvider());
        return httpSecurity.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(detalleUsuarioService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return  daoAuthenticationProvider;
    }

}