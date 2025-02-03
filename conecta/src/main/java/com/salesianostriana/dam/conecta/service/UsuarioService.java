package com.salesianostriana.dam.conecta.service;

import com.salesianostriana.dam.conecta.dtos.EditProfesorDto;
import com.salesianostriana.dam.conecta.dtos.EditUsuarioDto;
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
    public Usuario findUsuarioById(Long id) {
        Optional<Usuario> usuario = usuariorepo.findById(id);
        if(usuario.isEmpty()){
            throw new EntityNotFoundException("No se han encontrado usuario cone ese id ");
        }
        return usuario.get();
    }

    //Editar usuario usando el dto
    public Usuario editUsaurioo(EditUsuarioDto editUsuarioDto, Long id) {
        Optional<Usuario> usuarioOp = usuariorepo.findById(id);
        if(usuarioOp.isEmpty()){
            throw new EntityNotFoundException("No existen usuarios con ese id");
        }
        usuarioOp.get().setUsername(editUsuarioDto.username());
        usuarioOp.get().setPassword(editUsuarioDto.password());
        usuarioOp.get().setRole(editUsuarioDto.role());
        return usuariorepo.save(usuarioOp.get());
    }

}
