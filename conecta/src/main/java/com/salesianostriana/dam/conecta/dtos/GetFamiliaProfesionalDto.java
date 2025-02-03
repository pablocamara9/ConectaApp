package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Empresa;
import com.salesianostriana.dam.conecta.model.FamiliaProfesional;

import java.util.List;

public record GetFamiliaProfesionalDto(String nombre, List<Empresa> empresasAsociadas) {

    public static GetFamiliaProfesionalDto of(FamiliaProfesional dto) {
        return new GetFamiliaProfesionalDto(
                dto.getNombre(),
                dto.getEmpresasRelacionadas()
        );
    }
}
