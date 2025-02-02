package com.salesianostriana.dam.conecta.controller;

import com.salesianostriana.dam.conecta.dtos.EditEmpresaDto;
import com.salesianostriana.dam.conecta.model.Empresa;
import com.salesianostriana.dam.conecta.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/empresa/")
public class EmpresaController {

    private final EmpresaService empresaService;

    @GetMapping
    public List<Empresa> findAll() {
        return empresaService.findAll();
    }

    @PostMapping
    public ResponseEntity<Empresa> addEmpresa(@RequestBody EditEmpresaDto empresa) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(empresaService.save(empresa));
    }

}
