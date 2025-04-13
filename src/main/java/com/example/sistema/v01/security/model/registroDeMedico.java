package com.example.sistema.v01.security.model;

import com.example.sistema.v01.model.enums.areaMedica;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class registroDeMedico {
    private String username;
    private String password;
    private String nombres;
    private String apellido;
    private String correo;
    private String direccion;
    private String telefono_cel;
    private String telefono_fijo;
    private String dni;
    private areaMedica area_medica;
    private String cmp;
}
