package com.example.sistema.v01.service.PacienteService;

import java.util.List;
import java.util.Optional;

import com.example.sistema.v01.model.paciente;

public interface pacienteService {
    void savePaciente(paciente paciente);
    Optional<paciente> getByIdPaciente(Long id);
    void deleteByIdPaciente(Long id);
    List<paciente> findAllPaciente();
} 
