package com.salesianostriana.dam.conecta.controller;

import com.salesianostriana.dam.conecta.dtos.EditProfesorDto;
import com.salesianostriana.dam.conecta.model.Profesor;
import com.salesianostriana.dam.conecta.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesor/")
@RequiredArgsConstructor
//@Tag(name = "Profesor", description = "El controlador de profesores para gestionar sus operaciones "
public class ProfesorController {

    private final ProfesorService profesorService;

    /*DOCUMENTACION SWAGGER(FALTAN PROPIEDADES PARA USARLAS
    *
    * @Operation(summary = "Crea un nuevo profesor")
    * @ApiResponses(value = {
    *          @Apiresponse(responseCode = "201",
    *              description = "Profesor creado con éxito"
    *               content = {@Content(mediaType="application/json",
    *                 schema = @Schema(implementation= Bicicleta.classs))}
    * ),
    * @ApiResponse(responseCode ="400",
    *       description = "Datos invalidos para crear un Profesor",
    * content = @Content)
    *
    * */
    @PostMapping
    public ResponseEntity<Profesor> createProfesor(@RequestBody EditProfesorDto nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(profesorService.saveProfesor(nuevo));
    }


    }


