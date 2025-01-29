package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Curso;

//Dto Curso
public record EditCursoDto(String nombre, int horasEmpresa) {

    public static EditCursoDto of(Curso dto) {
        return new EditCursoDto(dto.getNombre(), dto.getHorasEmpresa()/*, EditCursoDto.of(dto.getProfesores())*/);
    }
}
