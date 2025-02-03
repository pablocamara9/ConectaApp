package com.salesianostriana.dam.conecta.service;

import com.salesianostriana.dam.conecta.repository.FamiliaProfesionalRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FamiliaProfesionalService {

    private final FamiliaProfesionalRepo familiaProfesionalRepo;

}
