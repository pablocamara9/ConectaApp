package com.salesianostriana.dam.conecta.controller;

import com.salesianostriana.dam.conecta.service.DemandaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/demanda/")
public class DemandaController {

    private final DemandaService demandaService;


}
