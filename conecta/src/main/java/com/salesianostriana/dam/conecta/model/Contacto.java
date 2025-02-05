package com.salesianostriana.dam.conecta.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "contacto")
public class Contacto {

    @EmbeddedId
    private ContactoPK contactoPK = new ContactoPK();

    private Date fecha;
    private String canal;
    private String descripcion;

    public Contacto(Profesor p , Trabajador t){
        this.profesor = p;
        this.trabajador = t;
    }
    //Asociación PROFESOR-CONTACTO
    @ManyToOne
    @MapsId("profesor_id")
    @JoinColumn(name =  "profesor_id")
    private Profesor profesor;

    //Métodos helpers
    public void addProfesor(Profesor p){
        p.getContactos().add(this);
        this.profesor = p;
    }
    public void removeProfesor(Profesor p){
        p.getContactos().remove(this);
    }

    //Asociación CONTACTO-TRABAJADOR
    @ManyToOne
    @MapsId("trabajador_id")
    @JoinColumn(name = "trabajador_id")
    private Trabajador trabajador;

    public void addTrabajador(Trabajador t){
        t.getContactos().add(this);
        this.trabajador = t;
    }
    public void removeTrabajador(Trabajador t){
        t.getContactos().remove(this);
    }

}
