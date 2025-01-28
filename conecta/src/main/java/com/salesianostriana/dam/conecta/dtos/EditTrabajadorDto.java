package com.salesianostriana.dam.conecta.dtos;

import com.salesianostriana.dam.conecta.model.Trabajador;

public record EditTrabajadorDto(String nombre, String apellidos, String email, String telefono, String puesto, String area) {

    public static EditTrabajadorDto of(Trabajador dto) {
        return new EditTrabajadorDto(
                dto.getNombre(),
                dto.getApellidos(),
                dto.getEmail(),
                dto.getTelefono(),
                dto.getPuesto(),
                dto.getArea()
        );
    }
}
