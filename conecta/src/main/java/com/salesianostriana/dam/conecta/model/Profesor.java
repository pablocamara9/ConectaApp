package com.salesianostriana.dam.conecta.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.proxy.HibernateProxy;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "profesor")
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
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "esDocenteEn",
            joinColumns = @JoinColumn(name = "profesor_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id"), // Debe coincidir con la relación en Curso
            foreignKey = @ForeignKey(name = "fk_profesor_es_docente_curso"),
            inverseForeignKey = @ForeignKey(name = "fk_curso_es_docente_profesor"))
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Curso> cursos = new HashSet<>();

    //Métodos helpers PROFESOR-CURSO
    public void addCurso(Curso curso) {
        this.cursos.add(curso);
        curso.getTeachers().add(this);
    }
    public void removeCurso(Curso curso) {
        this.cursos.remove(curso);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Profesor profesor = (Profesor) o;
        return getId() != null && Objects.equals(getId(), profesor.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
