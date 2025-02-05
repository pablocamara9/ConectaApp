package com.salesianostriana.dam.conecta.dtos;

import java.util.Date;

public record EditContactoDto(Long profesor_id, Long trabjador_id, Date fecha, String canal, String descripcion) {
}
