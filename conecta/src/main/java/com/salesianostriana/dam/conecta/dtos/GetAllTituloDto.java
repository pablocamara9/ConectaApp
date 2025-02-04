package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Titulo;
import lombok.Builder;

import java.util.List;

@Builder
public record GetAllTituloDto(
        List<GetTituloDto> listadoTituloDto
) {
    public static GetAllTituloDto fromDto(List<Titulo> listadoTituloSinProcesar) {
        return GetAllTituloDto.builder()
                .listadoTituloDto(listadoTituloSinProcesar.stream().map(GetTituloDto::of).toList())
                .build();
    }
}
