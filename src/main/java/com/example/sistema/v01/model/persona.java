package com.example.sistema.v01.model;

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
public abstract class persona {
    private String nombres;
    private String apellido;
    private String correo;
    private String direccion;
    private String telefono_cel;
    private String telefono_fijo;
    private Long dni;
}
