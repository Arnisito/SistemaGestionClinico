package com.example.sistema.v01.model;

import org.hibernate.validator.constraints.Length;

import com.example.sistema.v01.model.enums.genero;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
    @Length(max = 20 , message = "la fecha de nacimineto paso el limite de caracteres")
    private String fecha_nacimiento;

    @Column(name = "edad",nullable = false,length = 3)
    @Min(value = 0, message = "La edad no puede ser negativa")
    @Max(value = 150, message = "La edad no puede superar los 150 años")
    private Integer edad;

    @Column(name = "genero",nullable = false)
    @Enumerated(EnumType.STRING)
    private genero genero;

    @Column(name = "antecedentes",nullable = true,length = 3000)
    @Length(min = 0,max = 3000,message = "el atencedentes paso el limite de caracteres")
    private String antecendente;

}
