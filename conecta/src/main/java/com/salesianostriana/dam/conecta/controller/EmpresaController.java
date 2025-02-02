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

    @GetMapping("{id}")
    public Empresa findById(@PathVariable Long id) {
        return empresaService.findById(id);
    }

    @PutMapping("{id}")
    public Empresa edit(@PathVariable Long id, @RequestBody EditEmpresaDto empresa) {
        return empresaService.edit(empresa, id);
    }

}
