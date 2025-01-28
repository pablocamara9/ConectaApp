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

    public Empresa save(Empresa t) {
        return empresaRepo.save(Empresa.builder()
                .cif(t.getCif())
                .direccion(t.getDireccion())
                .coordenadas(t.getCoordenadas())
                .nombre(t.getNombre())
                .build());
    }

    public Empresa edit(Empresa t, Long id) {
        return empresaRepo.findById(id)
                .map(old -> {

                    return empresaRepo.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el Empresa con el id " + id));
    }

    public void delete(Long id) {
        empresaRepo.deleteById(id);
    }

}
