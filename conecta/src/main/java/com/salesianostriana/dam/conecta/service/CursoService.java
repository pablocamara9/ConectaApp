package com.salesianostriana.dam.conecta.service;

import com.salesianostriana.dam.conecta.dtos.EditCursoDto;
import com.salesianostriana.dam.conecta.model.Curso;
import com.salesianostriana.dam.conecta.repository.CursoRepo;
import com.salesianostriana.dam.conecta.repository.ProfesorRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CursoService {

    //Repositorios utilizados en el servicio
    private final CursoRepo cursoR;


    public List<Curso> findAllCursos() {
        List<Curso> cursos = cursoR.findAll();
        if(cursos.isEmpty()){
            throw new EntityNotFoundException("No se han encontrado cursos ");
        }
        return cursos;
    }

    //Buscar por id CURSOS
    public Curso findCursoById(Long id) {
        Optional<Curso> cursosOp= cursoR.findById(id);
        if(cursosOp.isEmpty()){
            throw new EntityNotFoundException("No se han encontrado cursos cone ese id ");
        }
        return cursosOp.get();
    }

    //Guardamos el curso usando el Dto
    public Curso saveCurso(EditCursoDto cursdto) {
        return cursoR.save(Curso.builder()
                .nombre(cursdto.nombre()).horasEmpresa(cursdto.horasEmpresa()).build());
    }

    //Editar curso usando el dto
    public Curso editarCurso(Long id, EditCursoDto cursdto) {
        Optional<Curso> cursosOp= cursoR.findById(id);
        if(cursosOp.isEmpty()){
            throw new EntityNotFoundException("No se han encontrado cursos con ese id ");
        }
        cursosOp.get().setNombre(cursdto.nombre());
        cursosOp.get().setHorasEmpresa(cursdto.horasEmpresa());
        return cursoR.save(cursosOp.get());
    }

    //Eliminar curso
    public void deleteCurso(Long id) {
        cursoR.deleteById(id);
    }
}
