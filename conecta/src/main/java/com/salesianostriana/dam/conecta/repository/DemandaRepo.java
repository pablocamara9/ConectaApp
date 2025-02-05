package com.salesianostriana.dam.conecta.repository;

import com.salesianostriana.dam.conecta.model.Demanda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandaRepo
        extends JpaRepository<Demanda, Long> {
}
