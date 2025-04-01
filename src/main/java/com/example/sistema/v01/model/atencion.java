package com.example.sistema.v01.model;

import com.example.sistema.v01.model.enums.estadoAtencion;
import com.example.sistema.v01.model.enums.tipoAtencion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class atencion {
    private Long id;
    private citas cita;
    private String diagnostico;
    private String tratamiento;
    private tipoAtencion tipoAtencion;
    private estadoAtencion atencion;
}
