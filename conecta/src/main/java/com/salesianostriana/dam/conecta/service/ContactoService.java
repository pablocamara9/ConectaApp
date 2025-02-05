package com.salesianostriana.dam.conecta.service;

import com.salesianostriana.dam.conecta.service.base.BaseServiceImpl;
import com.salesianostriana.dam.conecta.dtos.EditContactoDto;
import com.salesianostriana.dam.conecta.model.Contacto;
import com.salesianostriana.dam.conecta.model.ContactoPK;
import com.salesianostriana.dam.conecta.model.Profesor;
import com.salesianostriana.dam.conecta.model.Trabajador;
import com.salesianostriana.dam.conecta.repository.ContactoRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactoService
                extends BaseServiceImpl<Contacto, ContactoPK, ContactoRepo> {

    private final TrabajadorService trabajadorService;
    private final ProfesorService profesorService;
    private final ContactoRepo contactoRepo;

    //Guardar Comtacto
    public Contacto saveContacto(EditContactoDto contactoDto) {
        Trabajador trabajador = trabajadorService.findById(contactoDto.trabajador_id());

        Profesor profesor = profesorService.findProfesorById(contactoDto.profesor_id());

        Contacto contacto = Contacto.builder()
                .fecha(contactoDto.fecha())
                .canal(contactoDto.canal())
                .descripcion(contactoDto.descripcion())
                .trabajador(trabajador)
                .profesor(profesor)
                .build();

        return contactoRepo.save(contacto);
    }
    //Buscar por id
    public Contacto findbyId(ContactoPK id) {
        Optional<Contacto> contacto = contactoRepo.findById(id);
        if(contacto.isPresent()) {
            return contacto.get();
        }
        return null;
    }
    //Buscar todos los contactos por profesor
    public List<Contacto> findByProfesor(Profesor profesor) {
        List<Contacto> contactos = contactoRepo.findAll();
        if(profesor != null)
            throw new EntityNotFoundException("No existen profesores");
        return contactos;
    }
    //Editar Contacto
    public Contacto updateContacto(EditContactoDto editContactoDto, ContactoPK id) {
        Optional<Contacto> contactoOp = contactoRepo.findById(id);
        if(contactoOp.isEmpty()) {
            throw new EntityNotFoundException("No existen contacto");
        }
        Trabajador trabajador = trabajadorService.findById(editContactoDto.trabajador_id());

        Profesor profesor = profesorService.findProfesorById(editContactoDto.profesor_id());

        Contacto contacto = Contacto.builder()
                .fecha(editContactoDto.fecha())
                .canal(editContactoDto.canal())
                .descripcion(editContactoDto.descripcion())
                .trabajador(trabajador)
                .profesor(profesor)
                .build();
        return contactoRepo.save(contacto);

    }
    //Eliminar contacto
    public void deletecontactto(ContactoPK contactoPK) {
        contactoRepo.deleteById(contactoPK);
    }
}
