package com.salesianostriana.dam.conecta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;


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
        this.empresa.getTrabajadores().remove(e);
        e.setTrabajadores(null);
    }

    //Asociación TRABAJADOR-CONTACTO(profesor)
    //ASOCIACION PROFESOR-CONTACTO(trabajador)
    @OneToMany(mappedBy = "trabajador", fetch = FetchType.LAZY)
    @Builder.Default
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Contacto> contactos = new HashSet<>();

    //Métodos helper(trabajador-Contacto)
    public void addContacto(Contacto contacto) {
        this.contactos.add(contacto);
        contacto.setTrabajador(this);
    }
    public void removeContacto(Contacto contacto) {
        this.contactos.remove(contacto);

    }

}
