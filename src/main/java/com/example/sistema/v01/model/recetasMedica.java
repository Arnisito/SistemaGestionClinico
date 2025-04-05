package com.example.sistema.v01.model;


import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "recetaMedica")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class recetasMedica {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_receta")
    private UUID id;

    @ManyToOne(
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "id_paciente",
        referencedColumnName = "id_paciente"
    )
    private paciente paciente;
    
    @ManyToOne(
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "id_doctor",
        referencedColumnName = "id_doctor"
    )
    private doctor doctor;

    @Column(name = "fecha_creacion",nullable = false,length = 20)
    @Length(message = "La fecha de creacion a superado el max de caracteres",max = 20)
    @NotEmpty(message = "La fecha de creacion no puede estar vacia")
    private String fecha_creacion;

    @ManyToOne(
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "id_atencion",
        referencedColumnName = "id_atencion"
    )
    private atencion atencion;
}
