package com.salesianostriana.dam.conecta.controller;

import com.salesianostriana.dam.conecta.dtos.EditProfesorDto;
import com.salesianostriana.dam.conecta.model.Profesor;
import com.salesianostriana.dam.conecta.service.ProfesorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor/")
@RequiredArgsConstructor
@Tag(name = "Profesor", description = "El controlador de profesores para gestionar sus operaciones ")
public class ProfesorController {

    private final ProfesorService profesorService;

     @Operation(summary = "Crea una nuevo profesor")
        @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                 description = "profesor creadao con éxito",
                    content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Profesor.class))}),
                @ApiResponse(responseCode = "400",
            description = "Datos inválidos para crear la estación",
        content = @Content)
    })
@PostMapping
    public ResponseEntity<Profesor> createProfesor(@RequestBody EditProfesorDto nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(profesorService.saveProfesor(nuevo));
    }



    @Operation(summary = "Obtiene todos los porfesores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado las profesores",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Profesor.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                              {
                                                 "nombre" : "Pepe",
                                                 "apellidos":"Segura Rodriguez",
                                                 "email": "pepesegurarodriguez@gmail.com",
                                                 "telefono": "606 79 68 33"
                                            
                                              }
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se han encontrado profesores"
            )
    })
    @GetMapping
    public List<Profesor> getAll() {
        return profesorService.findallProfesores();
    }

    }


