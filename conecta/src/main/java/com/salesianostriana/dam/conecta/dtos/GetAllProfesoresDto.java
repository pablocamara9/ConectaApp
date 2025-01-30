package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Profesor;
import lombok.Builder;

import java.util.List;

@Builder
public record GetAllProfesoresDto(

        List<GetProfesorDto> listadoProfesores

) {

    public static GetAllProfesoresDto fromDto(List<Profesor> listadoProfesoresSinProcesar) {

        return GetAllProfesoresDto.builder()
                .listadoProfesores(listadoProfesoresSinProcesar.stream().map(GetProfesorDto::of).toList())
                .build();

    }

}
