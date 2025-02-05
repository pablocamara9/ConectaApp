package com.salesianostriana.dam.conecta.controller;

import com.salesianostriana.dam.conecta.dtos.EditContactoDto;
import com.salesianostriana.dam.conecta.dtos.EditCursoDto;
import com.salesianostriana.dam.conecta.dtos.GetAllContactoDto;
import com.salesianostriana.dam.conecta.model.Contacto;
import com.salesianostriana.dam.conecta.model.ContactoPK;
import com.salesianostriana.dam.conecta.model.Curso;
import com.salesianostriana.dam.conecta.service.ContactoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contacto/")
public class ContactoController {

    private final ContactoService contactoService;

    @Operation(summary = "Crea una nuevo contacto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "contacto creadao con éxito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Contacto.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Datos inválidos para crear un contacto",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<Contacto> createContacto(@RequestBody EditContactoDto nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(contactoService.saveContacto(nuevo));
    }


    @Operation(summary = "Obtiene todos los contacto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado los contacto",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Contacto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                              {
                                               
                                            
                                              }
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se han encontrado contactos"
            )
    })
    @GetMapping
    public ResponseEntity<GetAllContactoDto> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(GetAllContactoDto.fromDto(contactoService.findAll()));
    }

    @Operation(summary = "Obtiene un contacto por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado el contacto",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Contacto.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado el contacto con el ID proporcionado",
                    content = @Content)
    })
    @GetMapping("{id}")
    public Optional<Contacto> getContactoById(@PathVariable ContactoPK id) {
        return contactoService.findById(id);
    }

    @Operation(summary = "Elimina una contacto por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Contacto eliminada con éxito",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado un contacto con el ID proporcionado",
                    content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable ContactoPK id) {
        contactoService.deletecontactto(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Edita una contacto existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "contacto actualizado con éxito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Contacto.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado la contacto con el ID proporcionado",
                    content = @Content)
    })
    @PutMapping("{id}")
    public Contacto edit(@RequestBody EditContactoDto aEditar, @PathVariable ContactoPK id) {
        return contactoService.updateContacto(aEditar, id);
    }


}