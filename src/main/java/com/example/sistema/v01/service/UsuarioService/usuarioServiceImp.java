package com.example.sistema.v01.service.UsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.sistema.v01.model.usuario;
import com.example.sistema.v01.repository.usuarioRepository;

public class usuarioServiceImp implements usuarioService{

    @Autowired
    usuarioRepository repository;

    @Override
    public void savePaciente(usuario usuario) {
        repository.save(usuario);
    }

    @Override
    public Optional<usuario> getByIdUsuario(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void deleteByIdUsuario(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<usuario> findAllUsuario() {
        return repository.findAll();
    }
    
}
