package com.example.sistema.v01.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public abstract class persona {

    @Column(length = 255)
    private String nombres;
    @Column(length = 255)
    private String apellido;
    @Column(length = 255)
    private String correo;

    @Column(length = 255,nullable = true)
    private String direccion;
    @Column(length = 255,nullable = true)
    private String telefono_cel;
    @Column(length = 255,nullable = true)
    private String telefono_fijo;
    @Column(length = 10,nullable = false,unique=true)
    private Long dni;

}
