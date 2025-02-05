package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Contacto;
import lombok.Builder;

import java.util.Date;
@Builder
public record GetContactoDto(Long profesor_id, Long trabajador_id, Date fecha, String canal, String descripcion) {

    public static GetContactoDto of(Contacto contacto) {
        return GetContactoDto.builder()
                .fecha(contacto.getFecha())
                .canal(contacto.getCanal())
                .descripcion(contacto.getDescripcion())
                .profesor_id(contacto.getProfesor().getId())
                .trabajador_id(contacto.getTrabajador().getId())
                .build();
    }
}
