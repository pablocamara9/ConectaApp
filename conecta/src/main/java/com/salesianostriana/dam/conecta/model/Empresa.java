package com.salesianostriana.dam.conecta.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empresa {

    @Id
    @GeneratedValue
    private Long id;

    private String cif;
    private String direccion;
    private double coordenadas;
    private String nombre;

    @OneToMany(mappedBy = "empresa", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Trabajador> trabajadores = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "empresa_familias_profesionales",
            joinColumns = @JoinColumn(name = "empresa_id"),
            inverseJoinColumns = @JoinColumn(name = "familia_profesional_id")
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    private List<FamiliaProfesional> familiasProfesionales = new ArrayList<>();

    @OneToMany(mappedBy = "empresa", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Demanda> demandas = new ArrayList<>();

    // Empresa - FamiliaProfesional
    public void addFamiliaProfesional(FamiliaProfesional fp) {
        familiasProfesionales.add(fp);
        fp.getEmpresasRelacionadas().add(this);
    }

    public void removeFamiliaProfesional(FamiliaProfesional fp) {
        fp.getEmpresasRelacionadas().remove(this);
        familiasProfesionales.remove(fp);
    }

    // Empresa - Demanda
    public void addDemanda(Demanda d) {
        d.setEmpresa(this);
        demandas.add(d);
    }

    public void removeDemanda(Demanda d) {
        demandas.remove(d);
        d.setEmpresa(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Empresa empresa = (Empresa) o;
        return getId() != null && Objects.equals(getId(), empresa.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
