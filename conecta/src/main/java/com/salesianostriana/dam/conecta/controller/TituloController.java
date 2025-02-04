package com.salesianostriana.dam.conecta.controller;


import com.salesianostriana.dam.conecta.dtos.EditProfesorDto;
import com.salesianostriana.dam.conecta.dtos.EditTituloDto;
import com.salesianostriana.dam.conecta.model.Profesor;
import com.salesianostriana.dam.conecta.model.Titulo;
import com.salesianostriana.dam.conecta.service.TituloService;
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
@RequestMapping("/titulo/")
@RequiredArgsConstructor
@Tag(name = "Titulo", description = "El controlador de titulo para gestionar sus operaciones ")
public class TituloController {

    private final TituloService tituloService;


    @Operation(summary = "Crea una nuevo titulo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "titulo creadao con éxito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Titulo.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Datos inválidos para crear un titulo",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<EditTituloDto> createTitulo(@RequestBody Titulo nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(EditTituloDto.of(tituloService.saveTitulo(nuevo)));
    }


}
