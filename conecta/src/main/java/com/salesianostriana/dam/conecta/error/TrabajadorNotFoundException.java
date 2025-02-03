package com.salesianostriana.dam.conecta.error;

public class TrabajadorNotFoundException extends RuntimeException {

    public TrabajadorNotFoundException(String menssage) {
        super(menssage);
    }

    public TrabajadorNotFoundException(Long id) {
        super("No se encontró el trabajador con el id " + id);
    }
}
