package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Contacto;
import com.salesianostriana.dam.conecta.model.Profesor;
import lombok.Builder;

import java.util.List;

@Builder
public record GetProfesorDto(

        String nombre,
        String apellidos,
        String email,
        String telefono,
        List<String> nombreCursosProfesor,
        GetUsuarioDto usuario,
        List<Contacto> contacto

) {

    public static GetProfesorDto of(Profesor profesor) {

        return GetProfesorDto.builder()
                .nombre(profesor.getNombre())
                .apellidos(profesor.getApellidos())
                .email(profesor.getEmail())
                .telefono(profesor.getTelefono())
                .nombreCursosProfesor(profesor.getCursos().stream().map(x-> x.getNombre() + " ").toList())
                .usuario(GetUsuarioDto.of(profesor.getUsuario()))
                .contacto(profesor.getContactos().stream().toList())
                .build();

    }

}
