package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.FamiliaProfesional;
import com.salesianostriana.dam.conecta.model.Titulo;
import lombok.Builder;

import java.util.Date;
import java.util.List;

@Builder
public record GetTituloDto(
        String nombre,
        String grado,
        Date duracion,
        List<String> nombreCursosTitulos,
        GetFamiliaProfesionalDto nombreFpTitulos
) {
    public static GetTituloDto of(Titulo titulo) {
        return GetTituloDto.builder()
                .nombre(titulo.getNombre())
                .grado(titulo.getGrado())
                .duracion(titulo.getDuracion())
                .nombreCursosTitulos(titulo.getCursos().stream().map(x -> x.getNombre()+" ").toList())
                .nombreFpTitulos(GetFamiliaProfesionalDto.of(titulo.getFamiliaProfesional()))
                .build();

    }
}
