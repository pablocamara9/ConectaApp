package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Empresa;

import java.util.List;

public record GetEmpresaDto(String cif, String direccion, double coordenadas, String nombre, List<GetTrabajadorDto> trabajadores) {

    public static GetEmpresaDto of(Empresa dto) {
        return new GetEmpresaDto(
                dto.getCif(),
                dto.getDireccion(),
                dto.getCoordenadas(),
                dto.getNombre(),
                dto.getTrabajadores().stream().map(GetTrabajadorDto::of).toList()
        );
    }


}
