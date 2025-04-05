package com.example.sistema.v01.model;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import com.example.sistema.v01.model.enums.tipoAtencion;

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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "atencionMedica")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class atencion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_atencion")
    private UUID id;

    @OneToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER        
    )
    @JoinColumn(
        name = "id_cita",
        referencedColumnName = "id_cita",
        nullable = false
    )
    private cita cita;

    @Column(name = "diagnostico",nullable = false,length = 2000)
    @Length(message = "el diagnostico paso el limite de caracteres",max = 2000)
    private String diagnostico;
    @Column(name = "tratamiento",nullable = false,length = 2000)
    @Length(message = "el tratamiento paso el limite de caracteres",max = 2000)
    private String tratamiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_atencion")
    @NotNull(message = "el tipo de atencion no puede esta vacio")
    private tipoAtencion tipo_atencion;


}
