package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Curso;
import com.salesianostriana.dam.conecta.model.FamiliaProfesional;
import com.salesianostriana.dam.conecta.model.Titulo;
import lombok.Builder;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Builder
public record EditTituloDto(String nombre, Date duracion, String grado, Set<Curso> cursos, FamiliaProfesional familiaProfesional) {

    /*public static EditTituloDto of(Titulo titulo) {
        return EditTituloDto.builder().nombre(titulo.getNombre())
                .duracion(titulo.getDuracion())
                .grado(titulo.getGrado())
                .build();
    }*/
}
