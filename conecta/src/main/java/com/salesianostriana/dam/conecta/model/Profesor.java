package com.salesianostriana.dam.conecta.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.proxy.HibernateProxy;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder
@Entity
public class Profesor extends Persona{

    //Constructor
    public Profesor(Long id, String nombre, String apellidos, String email, String telefono) {
        super(id, nombre, apellidos, email, telefono);
    }

    //Asociación PROFESOR-USUARIO
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    //Asociación PROFESOR-CURSO
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "esDocenteEn",
    joinColumns = @JoinColumn(name = "profesor_id"),
    inverseJoinColumns = @JoinColumn(name = "curso_id"))
    @Builder.Default
    private Set<Curso> cursos = new HashSet<>();

    //Métodos helpers PROFESOR-Curso
    public void addCurso(Curso curso) {
        this.cursos.add(curso);
        curso.getProfesores().add(this);
    }
    public void removeCurso(Curso curso) {
        this.cursos.remove(curso);
        curso.getProfesores().remove(this);

    }

}
