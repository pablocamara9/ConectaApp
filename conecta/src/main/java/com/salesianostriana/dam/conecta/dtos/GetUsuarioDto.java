package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Profesor;
import com.salesianostriana.dam.conecta.model.Usuario;
import lombok.Builder;

@Builder
public record GetUsuarioDto(String username,
                            String password,
                            String role,
                            Profesor profesor)

                {
                    public static GetUsuarioDto of(Usuario usuario) {
                        return GetUsuarioDto.builder()
                                .username(usuario.getUsername())
                                .password(usuario.getPassword())
                                .role(usuario.getRole())
                                .profesor(usuario.getProfesor())
                                .build();
                    }
}
