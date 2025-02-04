package com.salesianostriana.dam.conecta.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
public class ContactoPK {

    private static final long serialVersionUID = 1L;

    private long profesor_id;
    private long trabajdor_id;
}
