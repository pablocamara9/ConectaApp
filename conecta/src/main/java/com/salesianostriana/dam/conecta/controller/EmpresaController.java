package com.salesianostriana.dam.conecta.controller;

import com.salesianostriana.dam.conecta.dtos.EditEmpresaDto;
import com.salesianostriana.dam.conecta.model.Empresa;
import com.salesianostriana.dam.conecta.model.Trabajador;
import com.salesianostriana.dam.conecta.service.EmpresaService;
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
@RequestMapping("/empresa/")
@Tag(name = "Empresa", description = "El controlador de trabajadores para gestionar todas las operaciones relacionadas con ellos")
public class EmpresaController {

    private final EmpresaService empresaService;

    @Operation(summary = "Obtiene todas las empresas y las devuelve en forma de listado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado las empresas",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Empresa.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                    "id": 1,
                                                    "cif": "12345678A",
                                                    "direccion": "C/ San Venecia, 6",
                                                    "coordenadas": -123.5,
                                                    "nombre": "Calzados Pepe",
                                                    "trabajadores": []
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se encontraron las empresas"
            )
    })
    @GetMapping
    public List<Empresa> findAll() {
        return empresaService.findAll();
    }

    @Operation(summary = "Crea una nueva empresa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Empresa creada con éxito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Empresa.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Datos inválidos para crear la empresa",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<Empresa> addEmpresa(@RequestBody EditEmpresaDto empresa) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(empresaService.save(empresa));
    }

    @Operation(summary = "Obtiene una empresa por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado la empresa",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Empresa.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se encontró la empresa con el id (id proporcionado)",
                    content = @Content)
    })
    @GetMapping("{id}")
    public Empresa findById(@PathVariable Long id) {
        return empresaService.findById(id);
    }

    @Operation(summary = "Edita una empresa existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Empresa actualizada con éxito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Empresa.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se encontró la empresa con el id (id proporcionado)",
                    content = @Content)
    })
    @PutMapping("{id}")
    public Empresa edit(@PathVariable Long id, @RequestBody EditEmpresaDto empresa) {
        return empresaService.edit(empresa, id);
    }

    @Operation(summary = "Elimina una empresa buscándola por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Empresa eliminada con éxito",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "No se encontró la empresa con el id (id proporcionado)",
                    content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        empresaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
