package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Usuario;
import lombok.Builder;

import java.util.List;

@Builder
public record GetAllUsuariosDto(
        List<GetUsuarioDto> listadoDeUsuarios
) {
    public static GetAllUsuariosDto getAllUsuariosDto(List<Usuario> listadoDeUsuariosSinProcesar) {
        return GetAllUsuariosDto.builder()
                .listadoDeUsuarios(listadoDeUsuariosSinProcesar.stream().map(GetUsuarioDto::of).toList())
                .build();
    }
}
