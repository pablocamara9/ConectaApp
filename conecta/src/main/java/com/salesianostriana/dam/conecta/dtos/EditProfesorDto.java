package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Profesor;
import lombok.Builder;

@Builder
public record EditProfesorDto(String nombre, String apellidos, String email, String telefono) {

    public static EditProfesorDto of(Profesor profesor) {
        return EditProfesorDto.builder()
                .nombre(profesor.getNombre())
                .apellidos(profesor.getApellidos())
                .email(profesor.getEmail())
                .telefono(profesor.getTelefono())
                .build();

    }
}
