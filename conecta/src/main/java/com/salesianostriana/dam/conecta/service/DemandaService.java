package com.salesianostriana.dam.conecta.service;

import com.salesianostriana.dam.conecta.dtos.EditDemandaDto;
import com.salesianostriana.dam.conecta.model.Demanda;
import com.salesianostriana.dam.conecta.repository.DemandaRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DemandaService {

    private final DemandaRepo demandaRepo;

    public List<Demanda> findAll() {
        List<Demanda> demandas = demandaRepo.findAll();
        if(demandas.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron demandas");
        }
        return demandas;
    }

    public Demanda findById(Long id) {
        Optional<Demanda> optDemanda = demandaRepo.findById(id);
        if(optDemanda.isEmpty()) {
            throw new EntityNotFoundException("No se encontró la demanda con el id " + id);
        }
        return optDemanda.get();
    }

    public Demanda save(EditDemandaDto dto) {
        return demandaRepo.save(Demanda.builder()
                .cantidadAlumnos(dto.cantidadAlumnos())
                .requisitos(dto.requisitos())
                .empresa(dto.empresa())
                .build());
    }

    public Demanda edit(EditDemandaDto dto, Long id) {
        return demandaRepo.findById(id)
                .map(old -> {
                    old.setCantidadAlumnos(dto.cantidadAlumnos());
                    old.setRequisitos(dto.requisitos());
                    old.setEmpresa(dto.empresa());
                    return demandaRepo.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la demanda con el id " + id));
    }

    public void delete(Long id) {
        demandaRepo.deleteById(id);
    }

}
