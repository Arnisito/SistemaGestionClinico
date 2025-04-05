package com.example.sistema.v01.controller;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistema.v01.model.paciente;
import com.example.sistema.v01.service.PacienteService.pacienteService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/paciente")
public class controladorPaciente {
    
    @Autowired
    private pacienteService service;
    

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPaciente(@PathVariable UUID id) {
        Optional<paciente>optional = service.getByIdPaciente(id);
        if(optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro al paciente");
    }
    

    @PostMapping("/add")
    public void añadirPaciente(@Valid @RequestBody paciente paciente) {
        service.savePaciente(paciente);
    }
    
    @GetMapping("/")
    public List<paciente> TotalDePaciente() {
        return service.findAllPaciente();
    }

    @DeleteMapping("/{id}")
    public void EliminarPaciente(@Valid @PathVariable UUID id){
        
    }
    
}
