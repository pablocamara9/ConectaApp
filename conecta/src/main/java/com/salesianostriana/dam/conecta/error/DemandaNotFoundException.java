package com.salesianostriana.dam.conecta.error;

public class DemandaNotFoundException extends RuntimeException {

    public DemandaNotFoundException(String message) {
        super(message);
    }

    public DemandaNotFoundException(Long id) {
        super("No se encontró la demanda con el id " + id);
    }
}
