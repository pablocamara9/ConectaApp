package com.salesianostriana.dam.conecta.util;

import com.salesianostriana.dam.conecta.model.Curso;
import com.salesianostriana.dam.conecta.model.Profesor;
import com.salesianostriana.dam.conecta.repository.CursoRepo;
import com.salesianostriana.dam.conecta.repository.ProfesorRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProfesorRepo profesorRepository;
    private final CursoRepo cursoRepository;

    @PostConstruct
    public void run() {

        Profesor profesor1 = new Profesor();
        profesor1.setNombre("Juan");
        profesor1.setApellidos("Pérez");
        profesor1.setEmail("juan.perez@escuela.com");
        profesor1.setTelefono("123456789");

        Profesor profesor2 = new Profesor();
        profesor2.setNombre("Ana");
        profesor2.setApellidos("López");
        profesor2.setEmail("ana.lopez@escuela.com");
        profesor2.setTelefono("987654321");

        Profesor profesor3 = new Profesor();
        profesor3.setNombre("Carlos");
        profesor3.setApellidos("Gómez");
        profesor3.setEmail("carlos.gomez@escuela.com");
        profesor3.setTelefono("555666777");

        profesorRepository.saveAll(List.of(profesor1, profesor2, profesor3));

        Curso curso1 = new Curso();
        curso1.setNombre("Java Básico");
        curso1.setHorasEmpresa(40);

        Curso curso2 = new Curso();
        curso2.setNombre("Desarrollo Web");
        curso2.setHorasEmpresa(60);

        Curso curso3 = new Curso();
        curso3.setNombre("Python Avanzado");
        curso3.setHorasEmpresa(80);

        cursoRepository.saveAll(List.of(curso1, curso2, curso3));

        profesor1.addCurso(curso1);
        profesor2.addCurso(curso2);
        profesor3.addCurso(curso3);

        profesorRepository.saveAll(List.of(profesor1, profesor2, profesor3));

        profesorRepository.findAll().forEach(System.out::println);
        cursoRepository.findAll().forEach(System.out::println);
    }
}
