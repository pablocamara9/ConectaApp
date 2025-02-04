package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Empresa;

public record EditDemandaDto(
        int cantidadAlumnos,
        String requisitos,
        Empresa empresa
) {
}
