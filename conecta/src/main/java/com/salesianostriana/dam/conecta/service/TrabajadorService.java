package com.salesianostriana.dam.conecta.service;

import com.salesianostriana.dam.conecta.dtos.EditTrabajadorDto;
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

    public Trabajador save(EditTrabajadorDto dto) {
        return trabajadorRepo.save(Trabajador.builder()
                .nombre(dto.nombre())
                .apellidos(dto.apellidos())
                .email(dto.email())
                .telefono(dto.telefono())
                .puesto(dto.puesto())
                .area(dto.area())
                .build());
    }

    public Trabajador edit(EditTrabajadorDto dto, Long id) {
        return trabajadorRepo.findById(id)
                .map(old -> {
                    old.setNombre(dto.nombre());
                    old.setApellidos(dto.apellidos());
                    old.setEmail(dto.email());
                    old.setTelefono(dto.telefono());
                    old.setPuesto(dto.puesto());
                    old.setArea(dto.area());
                    return trabajadorRepo.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el trabajador con el id " + id));
    }

    public void delete(Long id) {
        trabajadorRepo.deleteById(id);
    }


}
