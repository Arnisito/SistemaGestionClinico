package com.example.sistema.v01.service.UsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.sistema.v01.model.usuario;

public interface usuarioService {
    void savePaciente(usuario usuario);
    Optional<usuario> getByIdUsuario(UUID id);
    void deleteByIdUsuario(UUID id);
    List<usuario> findAllUsuario();
}
