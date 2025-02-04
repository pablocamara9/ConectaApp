package com.salesianostriana.dam.conecta.service;

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
    public Titulo saveTitulo(Titulo titulo) {
        return repo.save(titulo);
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

}
