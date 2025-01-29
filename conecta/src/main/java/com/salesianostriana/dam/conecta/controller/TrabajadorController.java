package com.salesianostriana.dam.conecta.controller;

import com.salesianostriana.dam.conecta.service.TrabajadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trabajador/")
public class TrabajadorController {

    private final TrabajadorService trabajadorService;

}
