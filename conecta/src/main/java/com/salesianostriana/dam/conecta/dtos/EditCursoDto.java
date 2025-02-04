package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Curso;

//Dto Curso
public record EditCursoDto(String nombre, int horasEmpresa, EditProfesorDto editProfesorDto, EditTituloDto editTituloDto) {


}
