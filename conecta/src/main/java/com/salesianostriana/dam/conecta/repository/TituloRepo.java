package com.salesianostriana.dam.conecta.repository;

import com.salesianostriana.dam.conecta.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TituloRepo
        extends JpaRepository<Titulo, Long> {
}
