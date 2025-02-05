package com.salesianostriana.dam.conecta.service;

import com.salesianostriana.dam.conecta.dtos.EditProfesorDto;
import com.salesianostriana.dam.conecta.model.Contacto;
import com.salesianostriana.dam.conecta.model.Profesor;
import com.salesianostriana.dam.conecta.repository.ProfesorRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfesorService {

    //Repositorios utilizados en el servicio
    private final  ProfesorRepo repo;

    //Buscar todos los profesores
    public List<Profesor> findallProfesores() {
        List<Profesor> profesores = repo.findAll();
        if(profesores.isEmpty())
            throw new EntityNotFoundException("No existen profesores");
        return profesores;
    }

    //Buscar por id Profesores
    public Profesor findProfesorById(Long id) {
        Optional<Profesor> profesor = repo.findById(id);
        if(profesor.isEmpty()){
            throw new EntityNotFoundException("No se han encontrado profesor cone ese id ");
        }
        return profesor.get();
    }

    //Guardamos el profesor
    public Profesor saveProfesor(EditProfesorDto profesor) {
        return repo.save(Profesor.builder()
                        .nombre(profesor.nombre())
                        .email(profesor.email())
                        .telefono(profesor.telefono())
                        .apellidos(profesor.apellidos())
                        .cursos(profesor.cursos())
                        .usuario(profesor.usuario())
                        .contactos(profesor.contacto())
                        //Demanda
                .build());
    }

    //Editar profesor usando el dto
    public Profesor editProfesor(EditProfesorDto profesorDto, Long id) {
        Optional<Profesor> profesorOp = repo.findById(id);
        if(profesorOp.isEmpty()){
            throw new EntityNotFoundException("No existen profesores con ese id");
        }
        profesorOp.get().setNombre(profesorDto.nombre());
        profesorOp.get().setEmail(profesorDto.email());
        profesorOp.get().setApellidos(profesorDto.apellidos());
        profesorOp.get().setTelefono(profesorDto.telefono());
        profesorOp.get().setCursos(profesorDto.cursos());
        profesorOp.get().setUsuario(profesorDto.usuario());
        profesorOp.get().setContactos(profesorDto.contacto());


        return repo.save(profesorOp.get());
    }

    //Eliminar profesor
    public void deleteProfesor(Long id) {
        repo.deleteById(id);
    }

    //Buscar Profesores asociados con un curso

}
