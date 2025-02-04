package com.salesianostriana.dam.conecta.error;

public class EmpresaNotFoundException extends RuntimeException {

    public EmpresaNotFoundException(String message) {
        super(message);
    }

    public EmpresaNotFoundException(Long id) {
        super("No se encontró la empresa con el id " + id);
    }
}
