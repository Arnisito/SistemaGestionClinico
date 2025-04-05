package com.example.sistema.v01.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sistema.v01.model.paciente;



@Repository
public interface pacienteRepository extends JpaRepository<paciente,UUID>{
} 
    

