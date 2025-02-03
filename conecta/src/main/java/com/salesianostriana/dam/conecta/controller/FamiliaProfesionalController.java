package com.salesianostriana.dam.conecta.controller;

import com.salesianostriana.dam.conecta.dtos.EditFamiliaProfesionalDto;
import com.salesianostriana.dam.conecta.dtos.GetFamiliaProfesionalDto;
import com.salesianostriana.dam.conecta.model.FamiliaProfesional;
import com.salesianostriana.dam.conecta.service.FamiliaProfesionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<FamiliaProfesional> addFamiliaProfesional(@RequestBody EditFamiliaProfesionalDto familiaProfesional) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(familiaProfesionalService.save(familiaProfesional));
    }

    @GetMapping("{id}")
    public GetFamiliaProfesionalDto findById(@PathVariable Long id) {
        return GetFamiliaProfesionalDto.of(familiaProfesionalService.findById(id));
    }

}
