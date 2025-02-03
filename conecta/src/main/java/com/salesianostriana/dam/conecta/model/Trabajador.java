package com.salesianostriana.dam.conecta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Trabajador extends Persona {

    private String puesto;
    private String area;

    @ManyToOne
    private Empresa empresa;

    public void addToEmpresa(Empresa e) {
        e.getTrabajadores().add(this);
        this.empresa = e;
    }

    public void removeFromEmpresa(Empresa e) {
        e.getTrabajadores().remove(this);
        this.empresa = null;
    }

}
