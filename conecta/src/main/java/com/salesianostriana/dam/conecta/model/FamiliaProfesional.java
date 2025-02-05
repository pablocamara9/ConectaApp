package com.salesianostriana.dam.conecta.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FamiliaProfesional {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    //Asociación FP-Titulo
<<<<<<< HEAD
    @OneToMany(mappedBy = "familia_profesional", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
=======
    @OneToMany(mappedBy = "familiaProfesional", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
>>>>>>> 238bd34aed828dabaffdd3f176346ef89345fbf0
    @EqualsAndHashCode.Exclude
    @Builder.Default
    @ToString.Exclude
    List<Titulo> titulosRelacionados = new ArrayList<>();

    //Métodos helpers de la asociación
    public void addTitulo(Titulo titulo) {
        titulo.setFamiliaProfesional(this);
        titulosRelacionados.add(titulo);
    }
    public void removeTitulo(Titulo titulo) {
        titulosRelacionados.remove(titulo);
        titulo.setFamiliaProfesional(null);
    }

    //Asociación FP-Empresa
    @ManyToMany(mappedBy = "familiasProfesionales", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    private List<Empresa> empresasRelacionadas = new ArrayList<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        FamiliaProfesional that = (FamiliaProfesional) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
