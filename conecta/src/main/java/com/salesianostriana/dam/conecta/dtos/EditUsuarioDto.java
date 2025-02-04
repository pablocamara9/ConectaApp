package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Profesor;
import com.salesianostriana.dam.conecta.model.Usuario;
import lombok.Builder;

@Builder
public record EditUsuarioDto( String password, String username, String role, Profesor profesor) {


    /*public static EditUsuarioDto of(Usuario usuario) {
        return EditUsuarioDto.builder()
                .password(usuario.getPassword())
                .username(usuario.getUsername())
                .role(usuario.getRole())
                .build();

    }*/
}
