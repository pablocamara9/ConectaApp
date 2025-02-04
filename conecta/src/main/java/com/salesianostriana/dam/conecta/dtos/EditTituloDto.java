package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Titulo;
import lombok.Builder;

import java.util.Date;

@Builder
public record EditTituloDto(String nombre, Date duracion, String grado) {

    public static EditTituloDto of(Titulo titulo) {
        return EditTituloDto.builder().nombre(titulo.getNombre())
                .duracion(titulo.getDuracion())
                .grado(titulo.getGrado())
                .build();
    }
}
