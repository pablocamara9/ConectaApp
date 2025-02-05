package com.salesianostriana.dam.conecta.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record EditContactoDto(
        @NotNull
        Long profesor_id,
        @NotNull
        Long trabajador_id,
        Date fecha, String canal, String descripcion) {
}
