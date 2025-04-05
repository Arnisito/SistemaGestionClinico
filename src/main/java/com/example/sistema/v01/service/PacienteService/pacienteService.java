package com.example.sistema.v01.service.PacienteService;

import java.util.List;
import java.util.UUID;

import com.example.sistema.v01.model.paciente;

public interface pacienteService {
    void savePaciente(paciente paciente);
    paciente getByIdPaciente(UUID id);
    boolean deleteByIdPaciente(UUID id);
    List<paciente> findAllPaciente();
} 
