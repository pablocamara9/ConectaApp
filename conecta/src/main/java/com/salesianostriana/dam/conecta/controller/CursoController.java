package com.salesianostriana.dam.conecta.controller;


import com.salesianostriana.dam.conecta.service.CursoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso/")
@RequiredArgsConstructor
@Tag(name = "Curso", description = "El controlador de cursos para gestionar sus operaciones ")
public class CursoController {

    private final CursoService cursoService;

    
}
