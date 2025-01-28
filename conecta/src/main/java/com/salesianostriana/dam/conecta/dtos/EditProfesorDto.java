package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Profesor;

public record EditProfesorDto(String nombre, String apellidos, String email, String telefono) {

    public static EditProfesorDto of(Profesor profesor) {
        return new EditProfesorDto(profesor.getNombre(), profesor.getApellidos(), profesor.getEmail(), profesor.getTelefono());
    }
}
