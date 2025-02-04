package com.salesianostriana.dam.conecta.repository;

import com.salesianostriana.dam.conecta.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabajadorRepo
        extends JpaRepository<Trabajador, Long> {
}
