package com.salesianostriana.dam.conecta.controller;

import com.salesianostriana.dam.conecta.service.FamiliaProfesionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/familiaProfesional/")
public class FamiliaProfesionalController {

    private final FamiliaProfesionalService familiaProfesionalService;

}
