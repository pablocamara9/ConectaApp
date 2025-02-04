package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Curso;
import com.salesianostriana.dam.conecta.model.Profesor;
import com.salesianostriana.dam.conecta.model.Usuario;
import lombok.Builder;

import java.util.List;
import java.util.Set;

@Builder
public record EditProfesorDto(String nombre, String apellidos, String email, String telefono, Set<Curso> cursos, Usuario usuario) {

    /*public static EditProfesorDto of(Profesor profesor) {
        return EditProfesorDto.builder()
                .nombre(profesor.getNombre())
                .apellidos(profesor.getApellidos())
                .email(profesor.getEmail())
                .telefono(profesor.getTelefono())
                .build();

    }*/
}
