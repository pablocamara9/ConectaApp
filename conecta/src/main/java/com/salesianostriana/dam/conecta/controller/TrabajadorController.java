package com.salesianostriana.dam.conecta.controller;

import com.salesianostriana.dam.conecta.dtos.EditTrabajadorDto;
import com.salesianostriana.dam.conecta.model.Trabajador;
import com.salesianostriana.dam.conecta.service.TrabajadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trabajador/")
public class TrabajadorController {

    private final TrabajadorService trabajadorService;

    @GetMapping
    public List<Trabajador> getAll() {
        return trabajadorService.findAll();
    }

    @PostMapping
    public ResponseEntity<Trabajador> addTrabajador(@RequestBody EditTrabajadorDto trabajador) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(trabajadorService.save(trabajador));
    }

    @GetMapping("{id}")
    public Trabajador findById(@PathVariable Long id) {
        return trabajadorService.findById(id);
    }


}
