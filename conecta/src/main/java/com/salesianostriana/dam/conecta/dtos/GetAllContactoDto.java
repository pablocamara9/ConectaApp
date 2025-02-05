package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Contacto;
import lombok.Builder;

import java.util.List;

@Builder
public record GetAllContactoDto(
        List<GetContactoDto> listadoContactoDto
) {
    public static GetAllContactoDto fromDto(List<Contacto> listadoContactoSinProcesar) {
        return  GetAllContactoDto.builder()
                .listadoContactoDto(
                        listadoContactoSinProcesar
                                .stream()
                                .map(GetContactoDto::of).
                                toList())
                .build();
    }
}
