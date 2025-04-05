package com.example.sistema.v01.service.PacienteService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistema.v01.model.paciente;
import com.example.sistema.v01.repository.pacienteRepository;

@Service
public class pacienteServiceImp implements pacienteService{

    @Autowired
    private pacienteRepository repository;

    @Override
    public void savePaciente(paciente paciente) {
        repository.save(paciente);
    }

    @Override
    public Optional<paciente> getByIdPaciente(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void deleteByIdPaciente(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<paciente> findAllPaciente() {
        return repository.findAll();
    }
}
