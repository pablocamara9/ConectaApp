package com.salesianostriana.dam.conecta.service;


import com.salesianostriana.dam.conecta.error.DemandaNotFoundException;
import com.salesianostriana.dam.conecta.model.Demanda;
import com.salesianostriana.dam.conecta.repository.DemandaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DemandaService {

    private final DemandaRepo demandaRepo;
    private final EmpresaService empresaService;

    public List<Demanda> findAll() {
        List<Demanda> demandas = demandaRepo.findAll();
        if(demandas.isEmpty()) {
            throw new DemandaNotFoundException("No se encontraron demandas");
        }
        return demandas;
    }

    public Demanda findById(Long id) {
        Optional<Demanda> optDemanda = demandaRepo.findById(id);
        if(optDemanda.isEmpty()) {
            throw new DemandaNotFoundException("No se encontró la demanda con el id " + id);
        }
        return optDemanda.get();
    }

    public Demanda save(Demanda demanda, Long empresaId) {
        demanda.setEmpresa(empresaService.findById(empresaId));
        return demandaRepo.save(demanda);
    }

    public Demanda edit(Demanda demanda, Long id, Long empresaId) {
        return demandaRepo.findById(id)
                .map(old -> {
                    old.setCantidadAlumnos(demanda.getCantidadAlumnos());
                    old.setRequisitos(demanda.getRequisitos());
                    old.setEmpresa(empresaService.findById(empresaId));
                    return demandaRepo.save(old);
                })
                .orElseThrow(() -> new DemandaNotFoundException("No se encontró la demanda con el id " + id));
    }

    public void delete(Long id) {
        demandaRepo.deleteById(id);
    }

}
