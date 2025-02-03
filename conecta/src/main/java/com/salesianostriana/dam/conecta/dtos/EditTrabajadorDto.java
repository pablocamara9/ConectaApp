package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Empresa;
import com.salesianostriana.dam.conecta.model.Trabajador;

public record EditTrabajadorDto(
        String nombre,
        String apellidos,
        String email,
        String telefono,
        String puesto,
        String area,
        Empresa empresa
    ) {
}
