package com.choco.chocoapi.service;

import com.choco.chocoapi.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> buscarUsuarioPorID(Long id);

    List<Usuario> buscarTodosUsuarios();

    Usuario crearUsuario(Usuario usuario);

    Usuario actualizarUsuario(Usuario usuario);

    void eliminarUsuario(Long id);

}
