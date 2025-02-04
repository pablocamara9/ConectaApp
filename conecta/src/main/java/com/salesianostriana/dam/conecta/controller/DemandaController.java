package com.salesianostriana.dam.conecta.controller;

import com.salesianostriana.dam.conecta.dtos.EditDemandaDto;
import com.salesianostriana.dam.conecta.dtos.GetDemandaDto;
import com.salesianostriana.dam.conecta.dtos.GetEmpresaDto;
import com.salesianostriana.dam.conecta.model.Demanda;
import com.salesianostriana.dam.conecta.service.DemandaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/demanda/")
public class DemandaController {

    private final DemandaService demandaService;

    @GetMapping
    public List<GetDemandaDto> findAll() {
        return demandaService.findAll().stream().map(GetDemandaDto::of).toList();
    }

    @PostMapping
    public ResponseEntity<Demanda> add(@RequestBody EditDemandaDto demanda) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(demandaService.save(demanda));
    }

    @GetMapping("{id}")
    public GetDemandaDto findById(@PathVariable Long id) {
        return GetDemandaDto.of(demandaService.findById(id));
    }

    @PutMapping("{id}")
    public GetDemandaDto edit(@PathVariable Long id, @RequestBody EditDemandaDto demanda) {
        return GetDemandaDto.of(demandaService.edit(demanda, id));
    }

}
