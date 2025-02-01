package com.salesianostriana.dam.conecta.service;

import com.salesianostriana.dam.conecta.model.Profesor;
import com.salesianostriana.dam.conecta.model.Usuario;
import com.salesianostriana.dam.conecta.repository.Usuariorepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final Usuariorepo usuariorepo;
    //Guardamos el usuario
    public Profesor saveUsuario(Usuario usuario) {

        return usuariorepo.save(usuario);
    }

}
