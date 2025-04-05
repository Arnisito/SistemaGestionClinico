package com.example.sistema.v01.service.DoctorService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.sistema.v01.model.doctor;
import com.example.sistema.v01.repository.doctorRepository;

public class doctorServiceImp implements doctorService{

    @Autowired
    doctorRepository repository;

    @Override
    public void saveDoctor(doctor doctor) {
        repository.save(doctor);
    }

    @Override
    public Optional<doctor> getByIdDoctor(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void deleteByIdDoctor(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<doctor> findAllDoctor() {
        return repository.findAll();
    }
    
}
