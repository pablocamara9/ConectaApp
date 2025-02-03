package com.salesianostriana.dam.conecta.service;

import com.salesianostriana.dam.conecta.model.Profesor;
import com.salesianostriana.dam.conecta.model.Usuario;
import com.salesianostriana.dam.conecta.repository.Usuariorepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final Usuariorepo usuariorepo;

    //Guardamos el usuario
    public Usuario saveUsuario(Usuario usuario) {
        return usuariorepo.save(usuario);
    }

    //Buscar todos los usuarios
    public List<Usuario> findallUsuarios() {
        List<Usuario> usuarios = usuariorepo.findAll();
        if(usuarios.isEmpty())
            throw new EntityNotFoundException("No existen usuarios");
        return usuarios;
    }

    //Buscar por id Usuarios
    public Profesor findUsuarioById(Long id) {
        Optional<Usuario> usuario = usuariorepo.findById(id);
        if(usuario.isEmpty()){
            throw new EntityNotFoundException("No se han encontrado usuario cone ese id ");
        }
        return usuario.get().getProfesor();
    }

}
