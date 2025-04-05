package com.example.sistema.v01.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sistema.v01.model.cita;

@Repository
public interface citaRepository extends JpaRepository<cita,UUID>{
    
}
