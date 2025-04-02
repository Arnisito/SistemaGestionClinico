package com.example.sistema.v01.model;

import com.example.sistema.v01.model.enums.areaMedica;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="doctor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class doctor extends persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doctor")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "area_medica",nullable = false,unique = true)
    private areaMedica area_medica;
    @Column(name = "cmp_doc",nullable = false,unique = true)
    private Long cmp;
}
