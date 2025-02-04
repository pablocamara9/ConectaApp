package com.salesianostriana.dam.conecta.controller;

import com.salesianostriana.dam.conecta.dtos.GetDemandaDto;
import com.salesianostriana.dam.conecta.model.Demanda;
import com.salesianostriana.dam.conecta.service.DemandaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
