package com.salesianostriana.dam.conecta.repository;

import com.salesianostriana.dam.conecta.dtos.EditProfesorDto;
import com.salesianostriana.dam.conecta.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfesorRepo
        extends JpaRepository<Profesor, Long> {
    @Query("""
    select new com.salesianostriana.dam.conecta.dtos.EditProfesorDto(
     p.nombre, p.apellidos,p.email, p.telefono)
    from Profesor p join p.cursos t
    where t.nombre = :cursoNombre
    """)
    List<EditProfesorDto> infoBasicaProfesoressPorCurso(String cursoNombre);

}
