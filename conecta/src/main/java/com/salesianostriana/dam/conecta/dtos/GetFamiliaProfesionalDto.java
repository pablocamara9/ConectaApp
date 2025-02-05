package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.FamiliaProfesional;
import com.salesianostriana.dam.conecta.model.Titulo;

import java.util.List;


public record GetFamiliaProfesionalDto(String nombre, List<GetEmpresaDto> empresasAsociadas, List<Titulo> titulosAsociados) {
  
    public static GetFamiliaProfesionalDto of(FamiliaProfesional dto) {
        return new GetFamiliaProfesionalDto(
                dto.getNombre(),
                dto.getEmpresasRelacionadas().stream().map(GetEmpresaDto::of).toList(),
                dto.getTitulosRelacionados()
        );
    }
}
