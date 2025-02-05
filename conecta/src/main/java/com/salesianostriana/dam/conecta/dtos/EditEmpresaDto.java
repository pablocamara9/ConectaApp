package com.salesianostriana.dam.conecta.dtos;


import com.salesianostriana.dam.conecta.model.Trabajador;

import java.util.List;


public record EditEmpresaDto(
        String cif,
        String direccion,
        double coordenadas,
        String nombre,
        List<Trabajador> trabajadores
) {
}
