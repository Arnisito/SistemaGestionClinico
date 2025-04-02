package com.example.sistema.v01.model;

import com.example.sistema.v01.model.enums.estadoAtencion;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atencion")
    private Long id;

    @OneToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER        
    )
    @JoinColumn(
        name = "id_cita",
        referencedColumnName = "id_cita"
    )
    private cita cita;

    @Column(name = "diagnostico",nullable = false,length = 2000)
    private String diagnostico;
    @Column(name = "tratamiento",nullable = false,length = 2000)
    private String tratamiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_atencion")
    private tipoAtencion tipo_atencion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_atencion")
    private estadoAtencion atencion;

    @ManyToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    @JoinColumn(
        name = "id_historial_atencion",
        referencedColumnName = "id_historial_atencion"
    )
    private historialAtenciones historialAtenciones;
}
