package com.salesianostriana.dam.conecta.controller;


import com.salesianostriana.dam.conecta.dtos.EditCursoDto;
import com.salesianostriana.dam.conecta.dtos.EditProfesorDto;
import com.salesianostriana.dam.conecta.model.Curso;
import com.salesianostriana.dam.conecta.model.Profesor;
import com.salesianostriana.dam.conecta.service.CursoService;
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
    @Operation(summary = "Obtiene todas los cursos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado cursos",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EditCursoDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {"nombre":"1 DAM", "horasEmpresa":"60" }
                                                {"nombre":"2 DAM", "horasEmpresa":"160" }
                                            ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se han encontrado cursos",
                    content = @Content)
    })
    @GetMapping
    public List<EditCursoDto> getAll() {
        return cursoService.findAllCursos()
                .stream()
                .map(EditCursoDto::of)
                .toList();
    }


    @Operation(summary = "Obtiene un curso por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado el curso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Curso.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado el curso con el ID proporcionado",
                    content = @Content)
    })
    @GetMapping("{id}")
    public Curso getCursoById(@PathVariable Long id) {
        return cursoService.findCursoById(id);
    }

    @Operation(summary = "Elimina una curso por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Curso eliminada con éxito",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado un curso con el ID proporcionado",
                    content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        cursoService.deleteCurso(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Edita una curso existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "curso actualizado con éxito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Curso.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado la Curso con el ID proporcionado",
                    content = @Content)
    })
    @PutMapping("{id}")
    public Curso edit(@RequestBody EditCursoDto aEditar, @PathVariable Long id) {
        return cursoService.editarCurso(id,aEditar);
    }
}

