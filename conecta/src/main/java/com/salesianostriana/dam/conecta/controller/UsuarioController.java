package com.salesianostriana.dam.conecta.controller;

import com.salesianostriana.dam.conecta.dtos.EditProfesorDto;
import com.salesianostriana.dam.conecta.dtos.EditUsuarioDto;
import com.salesianostriana.dam.conecta.dtos.GetAllProfesoresDto;
import com.salesianostriana.dam.conecta.dtos.GetAllUsuariosDto;
import com.salesianostriana.dam.conecta.model.Profesor;
import com.salesianostriana.dam.conecta.model.Usuario;
import com.salesianostriana.dam.conecta.service.ProfesorService;
import com.salesianostriana.dam.conecta.service.UsuarioService;
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

@RestController
@RequestMapping("/usuario/")
@RequiredArgsConstructor
@Tag(name = "Usuario", description = "El controlador de usuario ")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Operation(summary = "Crea una nuevo usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "usuario creadao con éxito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Datos inválidos para crear un profesor",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<EditUsuarioDto> createUsuario(@RequestBody Usuario nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(EditUsuarioDto.of(usuarioService.saveUsuario(nuevo)));
    }

    @Operation(summary = "Obtiene todos los usuarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado los usuarios",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Usuario.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                              {
                                                 "username" : "ppsegur",
                                                 "password":"1234",
                                                 "role": "director/admin",                                            
                                              }
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se han encontrado usuarios"
            )
    })
    @GetMapping
    public ResponseEntity<GetAllUsuariosDto> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(GetAllUsuariosDto.fromDto(usuarioService.findallUsuarios()));
    }

}