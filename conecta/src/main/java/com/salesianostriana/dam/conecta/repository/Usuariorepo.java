package com.salesianostriana.dam.conecta.repository;

import com.salesianostriana.dam.conecta.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Usuariorepo extends JpaRepository<Usuario, Long> {
}
