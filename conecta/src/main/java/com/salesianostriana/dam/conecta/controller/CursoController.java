package com.salesianostriana.dam.conecta.controller;


import com.salesianostriana.dam.conecta.dtos.EditCursoDto;
import com.salesianostriana.dam.conecta.dtos.EditProfesorDto;
import com.salesianostriana.dam.conecta.model.Curso;
import com.salesianostriana.dam.conecta.model.Profesor;
import com.salesianostriana.dam.conecta.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso/")
@RequiredArgsConstructor
@Tag(name = "Curso", description = "El controlador de cursos para gestionar sus operaciones ")
public class CursoController {

    private final CursoService cursoService;

    @Operation(summary = "Crea una nuevo curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "curso creadao con éxito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Curso.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Datos inválidos para crear un curso",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<Curso> createCurso(@RequestBody EditCursoDto nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cursoService.saveCurso(nuevo));
    }

}
