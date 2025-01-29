package com.salesianostriana.dam.conecta.controller;

import com.salesianostriana.dam.conecta.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

}
