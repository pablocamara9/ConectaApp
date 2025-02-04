package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Empresa;
import com.salesianostriana.dam.conecta.model.Trabajador;

public record GetTrabajadorDto(String nombre, String apellidos, String email, String telefono, String puesto, String area, GetEmpresaDto empresa) {

    public static GetTrabajadorDto of(Trabajador dto) {
        return new GetTrabajadorDto(
                dto.getNombre(),
                dto.getApellidos(),
                dto.getEmail(),
                dto.getTelefono(),
                dto.getPuesto(),
                dto.getArea(),
                GetEmpresaDto.of(dto.getEmpresa())
        );
    }


}
