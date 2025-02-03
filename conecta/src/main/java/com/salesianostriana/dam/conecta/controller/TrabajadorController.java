package com.salesianostriana.dam.conecta.controller;

import com.salesianostriana.dam.conecta.dtos.EditTrabajadorDto;
import com.salesianostriana.dam.conecta.dtos.GetTrabajadorDto;
import com.salesianostriana.dam.conecta.model.Trabajador;
import com.salesianostriana.dam.conecta.service.TrabajadorService;
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
@RequestMapping("/trabajador/")
@Tag(name = "Trabajador", description = "El controlador de trabajadores para gestionar todas las operaciones relacionadas con ellos")
public class TrabajadorController {

    private final TrabajadorService trabajadorService;

    @Operation(summary = "Obtiene todos los trabajadores y los devuelve en forma de listado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado los trabajadores",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Trabajador.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": 1,
                                                "nombre": "Pepe",
                                                "apellidos": "Segura Rodríguez",
                                                "email": "segura.rojos23@triana.salesianos.edu",
                                                "telefono": "660232323",
                                                "puesto": "barrendero",
                                                "area": "basurero"
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se encontraron los trabajadores"
            )
    })
    @GetMapping
    public List<GetTrabajadorDto> getAll() {
        //return trabajadorService.findAll();
        return trabajadorService.findAll().stream().map(GetTrabajadorDto::of).toList();
    }

    @Operation(summary = "Crea un nuevo trabajador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Trabajador creado con éxito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Trabajador.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Datos inválidos para crear el trabajador",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<Trabajador> addTrabajador(@RequestBody EditTrabajadorDto trabajador) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(trabajadorService.save(trabajador));
    }

    @Operation(summary = "Obtiene un trabajador por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado el trabajador",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Trabajador.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se encontró el trabajador con el id (id proporcionado)",
                    content = @Content)
    })
    @GetMapping("{id}")
    public GetTrabajadorDto findById(@PathVariable Long id) {
        return GetTrabajadorDto.of(trabajadorService.findById(id));
    }

    @Operation(summary = "Edita un trabajador existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Trabajador actualizado con éxito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Trabajador.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se encontró el trabajador con el id (id proporcionado)",
                    content = @Content)
    })
    @PutMapping("{id}")
    public Trabajador edit(@PathVariable Long id, @RequestBody EditTrabajadorDto trabajador) {
        return trabajadorService.edit(trabajador, id);
    }

    @Operation(summary = "Elimina un trabajador buscándolo por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Trabajador eliminado con éxito",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "No se encontró el trabajador con el id (id proporcionado)",
                    content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        trabajadorService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
