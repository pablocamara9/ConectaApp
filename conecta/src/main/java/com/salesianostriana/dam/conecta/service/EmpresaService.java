package com.salesianostriana.dam.conecta.service;

import com.salesianostriana.dam.conecta.dtos.EditEmpresaDto;
import com.salesianostriana.dam.conecta.error.EmpresaNotFoundException;
import com.salesianostriana.dam.conecta.model.Empresa;
import com.salesianostriana.dam.conecta.repository.EmpresaRepo;
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
            throw new EmpresaNotFoundException("No se encontraron empresas");
        }
        return empresas;
    }

    public Empresa findById(Long id) {
        Optional<Empresa> empresaOpt = empresaRepo.findById(id);
        if(empresaOpt.isEmpty()) {
            throw new EmpresaNotFoundException("No se encontró la empresa con el id " + id);
        }
        return empresaOpt.get();
    }

    public Empresa save(EditEmpresaDto dto) {
        return empresaRepo.save(Empresa.builder()
                .cif(dto.cif())
                .direccion(dto.direccion())
                .coordenadas(dto.coordenadas())
                .nombre(dto.nombre())
                .trabajadores(dto.trabajadores())
                .build());
    }

    public Empresa edit(EditEmpresaDto dto, Long id) {
        return empresaRepo.findById(id)
                .map(old -> {
                    old.setCif(dto.cif());
                    old.setDireccion(dto.direccion());
                    old.setCoordenadas(dto.coordenadas());
                    old.setNombre(dto.nombre());
                    return empresaRepo.save(old);
                })
                .orElseThrow(() -> new EmpresaNotFoundException("No se encontró la empresa con el id " + id));
    }

    public void delete(Long id) {
        Optional<Empresa> empresaOpt = empresaRepo.findById(id);
        if(empresaOpt.isEmpty()) {
            throw new EmpresaNotFoundException("No se encontró la empresa con el id " + id);
        }
        Empresa e = empresaOpt.get();
        e.getTrabajadores().forEach(trabajador -> trabajador.removeFromEmpresa(e));

        empresaRepo.deleteById(id);
    }

}
