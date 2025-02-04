package com.salesianostriana.dam.conecta.controller;

import com.salesianostriana.dam.conecta.dtos.EditFamiliaProfesionalDto;
import com.salesianostriana.dam.conecta.dtos.GetFamiliaProfesionalDto;
import com.salesianostriana.dam.conecta.model.FamiliaProfesional;
import com.salesianostriana.dam.conecta.model.Trabajador;
import com.salesianostriana.dam.conecta.service.FamiliaProfesionalService;
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
@RequiredArgsConstructor
@RequestMapping("/familiaProfesional/")
@Tag(name = "Familia profesional", description = "El controlador de familias profesionales para gestionar todas las operaciones relacionadas con ellas")
public class FamiliaProfesionalController {

    private final FamiliaProfesionalService familiaProfesionalService;

    @Operation(summary = "Obtiene todas las familias profesionales y las devuelve en forma de listado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado las familias profesionales",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FamiliaProfesional.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "nombre": "Informática",
                                                "empresasAsociadas": []
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se encontraron las familias profesionales"
            )
    })
    @GetMapping
    public List<GetFamiliaProfesionalDto> getAll() {
        return familiaProfesionalService.findAll().stream().map(GetFamiliaProfesionalDto::of).toList();
    }

    @Operation(summary = "Crea una nueva familia profesional")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Familia profesional creada con éxito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FamiliaProfesional.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Datos inválidos para crear la familia profesional",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<FamiliaProfesional> addFamiliaProfesional(@RequestBody EditFamiliaProfesionalDto familiaProfesional) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(familiaProfesionalService.save(familiaProfesional));
    }

    @Operation(summary = "Obtiene una familia profesional por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado la familia profesional",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FamiliaProfesional.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se encontró la familia profesional con el id (id proporcionado)",
                    content = @Content)
    })
    @GetMapping("{id}")
    public GetFamiliaProfesionalDto findById(@PathVariable Long id) {
        return GetFamiliaProfesionalDto.of(familiaProfesionalService.findById(id));
    }

    @Operation(summary = "Edita una familia profesional existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Familia profesional actualizada con éxito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FamiliaProfesional.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se encontró la familia profesional con el id (id proporcionado)",
                    content = @Content)
    })
    @PutMapping("{id}")
    public GetFamiliaProfesionalDto edit(@PathVariable Long id, @RequestBody EditFamiliaProfesionalDto familiaProfesional) {
        return GetFamiliaProfesionalDto.of(familiaProfesionalService.edit(familiaProfesional, id));
    }

    @Operation(summary = "Elimina una familia profesional buscándola por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Familia profesional eliminada con éxito",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "No se encontró la familia profesional con el id (id proporcionado)",
                    content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        familiaProfesionalService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
