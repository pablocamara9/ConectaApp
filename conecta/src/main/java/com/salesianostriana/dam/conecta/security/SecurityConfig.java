package com.salesianostriana.dam.conecta.security;

import com.salesianostriana.dam.conecta.model.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public Usuario userDetailsService() {
        Usuario user = Usuario.builder().username("user")
                .password("{noop}1234")
                .role("USER")
                .build();

        Usuario admin = Usuario.builder().username("admin")
                .password("{noop}admin")
                .role("ADMIN")
                .build();

        return admin;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        // Control de acceso
        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers(HttpMethod.POST, "/task/").hasRole("ADMIN")
                .requestMatchers("/task/**").authenticated());

        return http.build();
    }
}