package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Curso;
import com.salesianostriana.dam.conecta.model.Titulo;
import lombok.Builder;

import java.util.Date;
import java.util.List;

@Builder
public record EditTituloDto(String nombre, Date duracion, String grado, List<Curso> cursos, EditTituloDto tituloDto) {

    /*public static EditTituloDto of(Titulo titulo) {
        return EditTituloDto.builder().nombre(titulo.getNombre())
                .duracion(titulo.getDuracion())
                .grado(titulo.getGrado())
                .build();
    }*/
}
