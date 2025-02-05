package com.salesianostriana.dam.conecta.controller;

import com.salesianostriana.dam.conecta.dtos.GetDemandaDto;
import com.salesianostriana.dam.conecta.model.Demanda;
import com.salesianostriana.dam.conecta.service.DemandaService;
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
@RequestMapping("/demanda/")
@Tag(name = "Demanda", description = "El controlador de demandas para gestionar todas las operaciones relacionadas con ellos")
public class DemandaController {

    private final DemandaService demandaService;

    @Operation(summary = "Obtiene todas las demandas y las devuelve en forma de listado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado las demandas",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetDemandaDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "cantidadAlumnos": 30,
                                                "requisitos": "Expericencia mínima en Java",
                                                "empresa": {
                                                    "cif": "B854128A",
                                                    "direccion": "Calle San Jacinto, 21",
                                                    "coordenadas": -23423.1234,
                                                    "nombre": "Una empresa cualquiera",
                                                    "trabajadores": [
                                                        {
                                                            "id": 1,
                                                            "nombre": "Juan Antonio",
                                                            "apellidos": "Pérez López",
                                                            "email": "j.antonio@triana.salesianos.edu",
                                                            "telefono": "660252525",
                                                            "puesto": "Responsable de departamento",
                                                            "area": "RRHH"
                                                        }
                                                    ]
                                                }
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se encontraron las demandas"
            )
    })
    @GetMapping
    public List<GetDemandaDto> findAll() {
        return demandaService.findAll().stream().map(GetDemandaDto::of).toList();
    }

    @Operation(summary = "Crea una nueva demanda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Demanda creada con éxito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Demanda.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Datos inválidos para crear la demanda",
                    content = @Content)
    })
    @PostMapping("empresa/{idEmpresa}")
    public ResponseEntity<Demanda> add(@RequestBody Demanda demanda, @PathVariable Long idEmpresa) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(demandaService.save(demanda, idEmpresa));
    }

    @Operation(summary = "Obtiene una demanda por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado la demanda",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetDemandaDto.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se encontró la demanda con el id (id proporcionado)",
                    content = @Content)
    })
    @GetMapping("{id}")
    public GetDemandaDto findById(@PathVariable Long id) {
        return GetDemandaDto.of(demandaService.findById(id));
    }

    @Operation(summary = "Edita una demanda existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Demanda actualizada con éxito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetDemandaDto.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se encontró la demanda con el id (id proporcionado)",
                    content = @Content)
    })
    @PutMapping("{id}/empresa/{idEmpresa}")
    public GetDemandaDto edit(@PathVariable Long id, @RequestBody Demanda demanda, @PathVariable Long idEmpresa) {
        return GetDemandaDto.of(demandaService.edit(demanda, id, idEmpresa));
    }

    @Operation(summary = "Elimina una demanda buscándola por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Demanda eliminada con éxito",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "No se encontró la demanda con el id (id proporcionado)",
                    content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        demandaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
