package com.salesianostriana.dam.conecta.error;

public class FamiliaProfesionalNotFoundException extends RuntimeException {

    public FamiliaProfesionalNotFoundException(String message) {
        super(message);
    }

    public FamiliaProfesionalNotFoundException(Long id) {
        super("No se encontró la familia profesional con el id " + id);
    }
}
