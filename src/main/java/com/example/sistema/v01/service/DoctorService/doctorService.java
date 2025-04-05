package com.example.sistema.v01.service.DoctorService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.sistema.v01.model.doctor;

public interface doctorService {
    void saveDoctor(doctor doctor);
    Optional<doctor> getByIdDoctor(UUID id);
    void deleteByIdDoctor(UUID id);
    List<doctor> findAllDoctor();
}
