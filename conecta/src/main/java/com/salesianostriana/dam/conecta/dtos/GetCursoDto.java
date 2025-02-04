package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Curso;
import lombok.Builder;

import java.util.List;

@Builder
public record GetCursoDto(  String nombre,
                           int horasEmpresa,
                           List<String> nombreCursosProfesor,
                            GetTituloDto tituloDto) {

    public static GetCursoDto of(Curso curso) {
        return GetCursoDto.builder()
                .nombre(curso.getNombre())
                .horasEmpresa(curso.getHorasEmpresa())
                .nombreCursosProfesor((curso.getTeachers().stream().map(x -> x.getNombre() +  " ").toList()))
                .tituloDto(GetTituloDto.of(curso.getTitulo()))
                .build();
    }
}

