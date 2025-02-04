package com.salesianostriana.dam.conecta.service;

import com.salesianostriana.dam.conecta.model.Titulo;
import com.salesianostriana.dam.conecta.repository.TituloRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TituloService {

    private final TituloRepo repo;

    //Guardar el título
    public Titulo saveTitulo(Titulo titulo) {
        return repo.save(titulo);
    }

}
