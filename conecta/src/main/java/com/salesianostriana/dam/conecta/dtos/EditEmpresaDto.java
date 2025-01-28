package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Empresa;

public record EditEmpresaDto(String cif, String direccion, double coordenadas, String nombre) {

    public static EditEmpresaDto of(Empresa dto) {
        return new EditEmpresaDto(
                dto.getCif(),
                dto.getDireccion(),
                dto.getCoordenadas(),
                dto.getNombre()
        );

    }
}
