package com.example.sistema.v01.model;

import com.example.sistema.v01.model.enums.genero;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class paciente extends persona{

    private String fecha_Nacimiento;
    private Integer edad;
    private genero genero;

}
