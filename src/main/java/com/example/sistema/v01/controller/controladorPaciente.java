package com.example.sistema.v01.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistema.v01.genericos.Uri_Generica;
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
    
    /***
     * 
     * @param id
     * @return "Crud basico"
    */

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPaciente(@PathVariable UUID id) {
        paciente paciente = service.getByIdPaciente(id);
        if(paciente!=null){
            return ResponseEntity.ok().body(paciente);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro al paciente del id :"+id);
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> añadirPaciente(@Valid @RequestBody paciente paciente) {
        service.savePaciente(paciente);
        URI locacion = Uri_Generica.MiUri("/paciente/{id}", paciente.getId());
        return ResponseEntity.created(locacion).body("Se a creado un nuevo recurso paciente");
    }
    
    @GetMapping("/")
    public ResponseEntity<?> TotalDePaciente() {
        List<paciente>ListaPacientes = service.findAllPaciente();
        if(ListaPacientes.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("La lista de pacientes esta vacia('No se ha registrado a ninguno aun')");
        }
        return ResponseEntity.ok().body(ListaPacientes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> EliminarPaciente(@Valid @PathVariable UUID id){
        boolean res = service.deleteByIdPaciente(id);
        if(!res){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encotro el id del paciente a eliminar: "+id);
        }
        return ResponseEntity.ok().body("Se elimino correctamente el paciente de la bd : "+id);
    }
    
}
