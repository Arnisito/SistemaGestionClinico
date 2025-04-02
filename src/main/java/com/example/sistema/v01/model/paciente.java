package com.example.sistema.v01.model;

import com.example.sistema.v01.model.enums.genero;

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
@Table(name = "paciente")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class paciente extends persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long id;
    @Column(name = "fecha_nacimiento",nullable = false,length = 20)
    private String fecha_nacimiento;
    @Column(name = "edad",nullable = false,length = 3)
    private Integer edad;
    @Column(name = "genero",nullable = false,unique = true)
    @Enumerated(EnumType.STRING)
    private genero genero;
    @Column(name = "antecedentes",nullable = false,length = 3000)
    private String antecendente;
}
