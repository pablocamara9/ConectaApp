package com.salesianostriana.dam.conecta.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.*;

@Entity
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="curso")
public class Curso {

    //Atributos de la clase
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private int horasEmpresa;


    //Asociación CURSOS-PROFESOR
    @ManyToMany(mappedBy = "cursos")
    @Builder.Default
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    private Set<Profesor> teachers = new HashSet<>();


    //Asocación CURSO_TIRULO
    @ManyToOne
    @JoinColumn(name = "titulo_id")
    private Titulo titulo;

    //Métodos helpers
    public void addToTitulo(Titulo t) {
        t.getCursos().add(this);
        this.titulo = t;
    }
    public void removeFromTitulo(Titulo t) {
        t.getCursos().remove(this);
    }
    //Equals & hasCode
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Curso curso = (Curso) o;
        return getId() != null && Objects.equals(getId(), curso.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
