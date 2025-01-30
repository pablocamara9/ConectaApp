package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Curso;
import lombok.Builder;

import java.util.List;

@Builder
public record GetAllCursosDto(
        List<GetCursoDto> listaCursos
) {

    public static GetAllCursosDto fromDto(List<Curso> listadoCursosSinProcesar){
            return GetAllCursosDto.builder()
                    .listaCursos(listadoCursosSinProcesar.stream().map(GetCursoDto:: of).toList()).build();

    }
}
