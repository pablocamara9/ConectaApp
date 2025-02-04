package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Demanda;
import com.salesianostriana.dam.conecta.model.Empresa;

public record GetDemandaDto(int cantidadAlumnos, String requisitos, GetEmpresaDto empresa) {

    public static GetDemandaDto of(Demanda dto) {
        return new GetDemandaDto(
                dto.getCantidadAlumnos(),
                dto.getRequisitos(),
                GetEmpresaDto.of(dto.getEmpresa())
        );
    }
}
