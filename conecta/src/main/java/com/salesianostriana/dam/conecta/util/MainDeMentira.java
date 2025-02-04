package com.salesianostriana.dam.conecta.util;

/*import com.salesianostriana.dam.conecta.model.Curso;
import com.salesianostriana.dam.conecta.model.Profesor;
import com.salesianostriana.dam.conecta.repository.CursoRepo;
import com.salesianostriana.dam.conecta.repository.ProfesorRepo;*/
import com.salesianostriana.dam.conecta.model.Empresa;
import com.salesianostriana.dam.conecta.model.FamiliaProfesional;
import com.salesianostriana.dam.conecta.model.Trabajador;
import com.salesianostriana.dam.conecta.repository.EmpresaRepo;
import com.salesianostriana.dam.conecta.repository.FamiliaProfesionalRepo;
import com.salesianostriana.dam.conecta.repository.TrabajadorRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final TrabajadorRepo trabajadorRepo;
    private final EmpresaRepo empresaRepo;
    private final FamiliaProfesionalRepo familiaProfesionalRepo;

    /*private final ProfesorRepo profesorRepository;
    private final CursoRepo cursoRepository;*/

    @PostConstruct
    public void run() {

        Trabajador t1 = Trabajador.builder()
                .nombre("Juan Antonio")
                .apellidos("Pérez López")
                .email("j.antonio@triana.salesianos.edu")
                .telefono("660252525")
                .puesto("Responsable de departamento")
                .area("RRHH")
                .build();

        Trabajador t2 = Trabajador.builder()
                .nombre("María")
                .apellidos("Domínguez Núñez")
                .email("m.dominguez@triana.salesianos.edu")
                .telefono("722161616")
                .puesto("Jefa de operaciones")
                .area("-")
                .build();

        Set<Trabajador> trabajadores = new HashSet<Trabajador>();

        Empresa e1 = Empresa.builder()
                .cif("B854128A")
                .direccion("Calle San Jacinto, 21")
                .coordenadas(-23423.1234)
                .nombre("Una empresa cualquiera")
                .trabajadores(trabajadores)
                .build();

        empresaRepo.save(e1);

        t1.addToEmpresa(e1);
        t2.addToEmpresa(e1);

        FamiliaProfesional fp1 = FamiliaProfesional.builder()
                .nombre("Informática")
                .empresasRelacionadas(empresaRepo.findAll())
                .build();

        FamiliaProfesional fp2 = FamiliaProfesional.builder()
                .nombre("Electricidad")
                .empresasRelacionadas(empresaRepo.findAll())
                .build();

        familiaProfesionalRepo.save(fp1);
        familiaProfesionalRepo.save(fp2);

        trabajadorRepo.save(t1);
        trabajadorRepo.save(t2);
        empresaRepo.save(e1);

        trabajadorRepo.findAll().forEach(System.out::println);
        empresaRepo.findAll().forEach(System.out::println);


        /*Curso curso1 = new Curso();
        curso1.setNombre("Java Básico");
        curso1.setHorasEmpresa(40);

        Curso curso2 = new Curso();
        curso2.setNombre("Desarrollo Web");
        curso2.setHorasEmpresa(60);

        Curso curso3 = new Curso();
        curso3.setNombre("Python Avanzado");
        curso3.setHorasEmpresa(80);

        cursoRepository.saveAll(List.of(curso1, curso2, curso3));




        Profesor profesor1 = new Profesor();
        profesor1.setNombre("Juan");
        profesor1.setApellidos("Pérez");
        profesor1.setEmail("juan.perez@escuela.com");
        profesor1.setTelefono("123456789");
        profesor1.addCurso(curso1);

        Profesor profesor2 = new Profesor();
        profesor2.setNombre("Ana");
        profesor2.setApellidos("López");
        profesor2.setEmail("ana.lopez@escuela.com");
        profesor2.setTelefono("987654321");
        profesor2.addCurso(curso2);

        Profesor profesor3 = new Profesor();
        profesor3.setNombre("Carlos");
        profesor3.setApellidos("Gómez");
        profesor3.setEmail("carlos.gomez@escuela.com");
        profesor3.setTelefono("555666777");
        profesor3.addCurso(curso3);
        profesorRepository.saveAll(List.of(profesor1, profesor2, profesor3));



        profesorRepository.findAll().forEach(System.out::println);
        cursoRepository.findAll().forEach(System.out::println);

        System.out.println(profesorRepository.infoBasicaProfesoressPorCurso("Java Básico"));
        System.out.println(profesorRepository.profesoresConCurso("Juan"));*/
    }
}