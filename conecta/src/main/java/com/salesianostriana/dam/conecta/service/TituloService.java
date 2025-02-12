package com.salesianostriana.dam.conecta.service;

import com.salesianostriana.dam.conecta.dtos.EditProfesorDto;
import com.salesianostriana.dam.conecta.dtos.EditTituloDto;
import com.salesianostriana.dam.conecta.model.Profesor;
import com.salesianostriana.dam.conecta.model.Titulo;
import com.salesianostriana.dam.conecta.repository.TituloRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TituloService {

    private final TituloRepo repo;

    //Guardar el título
    public Titulo saveTitulo(EditTituloDto titulo) {
        return repo.save(Titulo.builder()
                        .nombre(titulo.nombre())
                        .grado(titulo.grado())
                        .duracion(titulo.duracion())
                        .cursos(titulo.cursos())
                        .familiaProfesional(titulo.familiaProfesional())

                .build());
    }

    //Buscar todos los titulos
    public List<Titulo> findallTitulos() {
        List<Titulo> titulos = repo.findAll();
        if(titulos.isEmpty())
            throw new EntityNotFoundException("No existen titulos");
        return titulos;
    }

    //Buscar por id títulos
    public Titulo findTituloById(Long id) {
        Optional<Titulo> titulo = repo.findById(id);
        if(titulo.isEmpty()){
            throw new EntityNotFoundException("No se han encontrado titulo cone ese id ");
        }
        return titulo.get();
    }

    //Editar titulo usando el dto
    public Titulo editarTitulo(EditTituloDto tituloDto, Long id) {
        Optional<Titulo> tituloOp = repo.findById(id);
        if(tituloOp.isEmpty()){
            throw new EntityNotFoundException("No existen titulos con ese id");
        }
        tituloOp.get().setNombre(tituloDto.nombre());
        tituloOp.get().setDuracion(tituloDto.duracion());
        tituloOp.get().setGrado(tituloDto.grado());
        tituloOp.get().setCursos(tituloDto.cursos());
        tituloOp.get().setFamiliaProfesional(tituloDto.familiaProfesional());
        return repo.save(tituloOp.get());
    }

    //Eliminar titulo
    public void deleteTitulo(Long id) {
        repo.deleteById(id);
    }


    //Buscar títulos por su nombre
    public List<Titulo> obtenerTituloPorNombre(String nombre) {
        return repo.buscarTitulosPorNombre(nombre);
    }
}
