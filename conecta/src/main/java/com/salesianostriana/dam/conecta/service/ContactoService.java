package com.salesianostriana.dam.conecta.service;

import com.salesianostriana.dam.conecta.base.BaseServiceImpl;
import com.salesianostriana.dam.conecta.model.Contacto;
import com.salesianostriana.dam.conecta.model.ContactoPK;
import com.salesianostriana.dam.conecta.model.Profesor;
import com.salesianostriana.dam.conecta.model.Trabajador;
import com.salesianostriana.dam.conecta.repository.ContactoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactoService
                extends BaseServiceImpl<Contacto, ContactoPK, ContactoRepo> {

    private final TrabajadorService trabajadorService;
    private final ProfesorService profesorService;

    public Trabajador contactoTrabajador(Trabajador t, Profesor profesor) {

        for (Contacto p : t.getContactos()){
            Contacto contacto = new Contacto(profesor, t);
            contacto.addProfesor(profesor);
            contacto.addTrabajador(t);
            this.save(contacto);
        }

        return t;
    }

}
