package com.example.sistema.v01.model;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cita")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class cita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cita")
    private UUID id;

    @Column(length = 20,nullable = false)
    @NotEmpty(message = "No puede estar vacio la fecha de creacion de la cita")
    @Length(message = "La fecha de creacion a superado el max de caracteres",max = 20)
    private String fecha_creacion;

    @Column(length = 20,nullable = false)
    @NotEmpty(message = "No puede estar vacio la fecha pactada de la cita")
    @Length(message = "La fecha pactada a superado el max de caracteres",max = 20)
    private String fecha_pactada;

    @ManyToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER
    )
    @JoinColumn(referencedColumnName = "id_paciente" , name = "id_paciente",nullable = false)
    private paciente paciente;

    @ManyToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER
    )
    @JoinColumn(referencedColumnName = "id_doctor" , name = "id_doctor",nullable = false)
    private doctor doctor;

    @Column(length = 2000,nullable = true)
    @Length(message = "La descripcion a superado el max de caracteres (2000)",max = 2000)
    private String descripcion;

    
}
