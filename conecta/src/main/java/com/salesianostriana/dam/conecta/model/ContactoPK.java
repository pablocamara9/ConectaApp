package com.salesianostriana.dam.conecta.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
public class ContactoPK implements Serializable {

    private static final long serialVersionUID = 1L;

    private long profesor_id;
    private long trabajador_id;
}
