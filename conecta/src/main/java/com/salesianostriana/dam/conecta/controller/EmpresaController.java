package com.salesianostriana.dam.conecta.controller;

import com.salesianostriana.dam.conecta.dtos.EditEmpresaDto;
import com.salesianostriana.dam.conecta.model.Empresa;
import com.salesianostriana.dam.conecta.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/empresa/")
public class EmpresaController {

    private final EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> addEmpresa(@RequestBody EditEmpresaDto empresa) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(empresaService.save(empresa));
    }

}
