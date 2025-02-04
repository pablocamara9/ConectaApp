package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Empresa;

import java.util.List;

public record EditFamiliaProfesionalDto(
        String nombre,
        List<Empresa> empresasAsociadas
) {
}
