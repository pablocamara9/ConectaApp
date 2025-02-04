package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Empresa;
import com.salesianostriana.dam.conecta.model.Titulo;

import java.util.List;

public record EditFamiliaProfesionalDto(
        String nombre,
        List<Empresa> empresasAsociadas,
        List<Titulo> titulosAsociados
) {
}
