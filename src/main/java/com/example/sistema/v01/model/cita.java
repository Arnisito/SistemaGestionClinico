package com.example.sistema.v01.model;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long id;

    @Column(length = 20)
    private String fecha_creacion;
    @Column(length = 20)
    private String fecha_pactada;

    @ManyToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER
    )
    @JoinColumn(referencedColumnName = "id_paciente" , name = "id_paciente")
    private paciente paciente;

    @ManyToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER
    )
    @JoinColumn(referencedColumnName = "id_doctor" , name = "id_doctor")
    private doctor doctor;

    @Column(length = 2000)
    private String descripcion;

}
