package com.salesianostriana.dam.conecta.repository;

import com.salesianostriana.dam.conecta.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TituloRepo
        extends JpaRepository<Titulo, Long> {
    //Consulta que nos devolverá los titulos con el nombre x ,
    // atrayendo también los datos de la familia profesional
    @Query("""
            select t 
            from Titulo t left join fetch t.familiaProfesional fp
            where t.nombre like %?1%
            """)
    List<Titulo> buscarTitulosPorNombre(String nombre);
}

