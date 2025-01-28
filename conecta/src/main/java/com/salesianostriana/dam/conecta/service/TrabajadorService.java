package com.salesianostriana.dam.conecta.service;

import com.salesianostriana.dam.conecta.model.Trabajador;
import com.salesianostriana.dam.conecta.repository.TrabajadorRepo;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrabajadorService {

    private final TrabajadorRepo trabajadorRepo;

    public List<Trabajador> findAll() {
        List<Trabajador> trabajadores = trabajadorRepo.findAll();
        if(trabajadores.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron el trabajadores");
        }
        return trabajadores;
    }

    public Trabajador findById(Long id) {
        Optional<Trabajador> trabajadorOpt = trabajadorRepo.findById(id);
        if(trabajadorOpt.isEmpty()) {
            throw new EntityNotFoundException("No se encontró el trabajador con el id " + id);
        }
        return trabajadorOpt.get();
    }

    public Trabajador save(Trabajador t) {
        return trabajadorRepo.save(Trabajador.builder()
                .nombre(t.getNombre())
                .apellidos(t.getApellidos())
                .email(t.getEmail())
                .telefono(t.getTelefono())
                .puesto(t.getPuesto())
                .area(t.getArea())
                .build());
    }

    public Trabajador edit(Trabajador t, Long id) {
        return trabajadorRepo.findById(id)
                .map(old -> {
                    old.setNombre(t.getNombre());
                    old.setApellidos(t.getApellidos());
                    old.setEmail(t.getEmail());
                    old.setTelefono(t.getTelefono());
                    old.setPuesto(t.getPuesto());
                    old.setArea(t.getArea());
                    return trabajadorRepo.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el trabajador con el id " + id));
    }

    public void delete(Long id) {
        trabajadorRepo.deleteById(id);
    }


}
