package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Empresa;
import com.salesianostriana.dam.conecta.model.Trabajador;

import java.util.List;
import java.util.Set;

public record GetEmpresaDto(String cif, String direccion, double coordenadas, String nombre, Set<Trabajador> trabajadores) {

    public static GetEmpresaDto of(Empresa dto) {
        return new GetEmpresaDto(
                dto.getCif(),
                dto.getDireccion(),
                dto.getCoordenadas(),
                dto.getNombre(),
                dto.getTrabajadores()
        );
    }


}
