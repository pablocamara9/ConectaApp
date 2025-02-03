package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Empresa;
import com.salesianostriana.dam.conecta.model.Trabajador;

import java.util.Set;

public record EditEmpresaDto(
        String cif,
        String direccion,
        double coordenadas,
        String nombre,
        Set<Trabajador> trabajadores
) {
}
