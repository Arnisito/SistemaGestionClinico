package com.example.sistema.v01.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class citas {
    private Long id;
    private String fecha_creacion;
    private String fecha_pactada;
    private paciente paciente;
    private doctor doctor;
    private String descripcion;
}
