package com.salesianostriana.dam.conecta.repository;

import com.salesianostriana.dam.conecta.model.Contacto;
import com.salesianostriana.dam.conecta.model.ContactoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepo extends JpaRepository<Contacto, ContactoPK> {
}
