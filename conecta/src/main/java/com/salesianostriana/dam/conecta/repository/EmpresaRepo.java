package com.salesianostriana.dam.conecta.repository;

import com.salesianostriana.dam.conecta.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepo
        extends JpaRepository<Empresa, Long> {
}
