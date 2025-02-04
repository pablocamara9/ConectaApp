package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Curso;
import com.salesianostriana.dam.conecta.model.Profesor;
import com.salesianostriana.dam.conecta.model.Titulo;

import java.util.List;
import java.util.Set;

//Dto Curso
public record EditCursoDto(String nombre, int horasEmpresa, Set<Profesor> profesores, Titulo titulo) {


}
