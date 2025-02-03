package com.salesianostriana.dam.conecta.service;

import com.salesianostriana.dam.conecta.dtos.EditFamiliaProfesionalDto;
import com.salesianostriana.dam.conecta.error.FamiliaProfesionalNotFoundException;
import com.salesianostriana.dam.conecta.model.FamiliaProfesional;
import com.salesianostriana.dam.conecta.repository.FamiliaProfesionalRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FamiliaProfesionalService {

    private final FamiliaProfesionalRepo familiaProfesionalRepo;

    public List<FamiliaProfesional> findAll() {
        List<FamiliaProfesional> familiasProfesionales = familiaProfesionalRepo.findAll();
        if(familiasProfesionales.isEmpty()) {
            throw new FamiliaProfesionalNotFoundException("No se encontraron familias profesionales");
        }
        return familiasProfesionales;
    }

    public FamiliaProfesional findById(Long id) {
        Optional<FamiliaProfesional> familiaProfesionalOpt = familiaProfesionalRepo.findById(id);
        if(familiaProfesionalOpt.isEmpty()) {
            throw new FamiliaProfesionalNotFoundException("No se encontró la familia profesional con el id " + id);
        }
        return familiaProfesionalOpt.get();
    }

    public FamiliaProfesional save(EditFamiliaProfesionalDto dto) {
        return familiaProfesionalRepo.save(FamiliaProfesional.builder()
                .nombre(dto.nombre())
                .empresasRelacionadas(dto.empresasAsociadas())
                .build());
    }

    public FamiliaProfesional edit(EditFamiliaProfesionalDto dto, Long id) {
        Optional<FamiliaProfesional> familiaProfesionalOpt = familiaProfesionalRepo.findById(id);
        if(familiaProfesionalOpt.isEmpty()) {
            throw new FamiliaProfesionalNotFoundException("No se encontró la familia profesional con el id " + id);
        }
        return familiaProfesionalOpt.map(old -> {
            old.setNombre(dto.nombre());
            old.setEmpresasRelacionadas(dto.empresasAsociadas());
            return familiaProfesionalRepo.save(old);
        }).get();
    }

    public void delete(Long id) {
        familiaProfesionalRepo.deleteById(id);
    }

}
