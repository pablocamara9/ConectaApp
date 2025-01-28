package com.salesianostriana.dam.conecta.service;

import com.salesianostriana.dam.conecta.model.Empresa;
import com.salesianostriana.dam.conecta.model.Empresa;
import com.salesianostriana.dam.conecta.repository.EmpresaRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepo empresaRepo;

    public List<Empresa> findAll() {
        List<Empresa> empresas = empresaRepo.findAll();
        if(empresas.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron empresas");
        }
        return empresas;
    }

    public Empresa findById(Long id) {
        Optional<Empresa> EmpresaOpt = empresaRepo.findById(id);
        if(EmpresaOpt.isEmpty()) {
            throw new EntityNotFoundException("No se encontró la empresa con el id " + id);
        }
        return EmpresaOpt.get();
    }

    public Empresa save(Empresa e) {
        return empresaRepo.save(Empresa.builder()
                .cif(e.getCif())
                .direccion(e.getDireccion())
                .coordenadas(e.getCoordenadas())
                .nombre(e.getNombre())
                .build());
    }

    public Empresa edit(Empresa e, Long id) {
        return empresaRepo.findById(id)
                .map(old -> {
                    e.setCif(old.getCif());
                    e.setDireccion(old.getDireccion());
                    e.setCoordenadas(old.getCoordenadas());
                    e.setNombre(old.getNombre());
                    return empresaRepo.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la empresa con el id " + id));
    }

    public void delete(Long id) {
        empresaRepo.deleteById(id);
    }

}
