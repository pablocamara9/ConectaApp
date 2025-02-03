package com.salesianostriana.dam.conecta.controller;

import com.salesianostriana.dam.conecta.dtos.GetFamiliaProfesionalDto;
import com.salesianostriana.dam.conecta.service.FamiliaProfesionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/familiaProfesional/")
public class FamiliaProfesionalController {

    private final FamiliaProfesionalService familiaProfesionalService;

    @GetMapping
    public List<GetFamiliaProfesionalDto> getAll() {
        return familiaProfesionalService.findAll().stream().map(GetFamiliaProfesionalDto::of).toList();
    }

}
