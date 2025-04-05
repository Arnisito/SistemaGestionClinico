package com.example.sistema.v01.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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

    @Column(length = 255,nullable = false)
    @Length(max = 255,message = "El nombre paso el limite de caracteres")
    @NotEmpty(message = "No puede estar vacio el nombre")
    private String nombres;

    @Column(length = 255 ,nullable = false)
    @Length(max = 255,message = "El apellido paso el limite de caracteres")
    @NotEmpty(message = "No puede estar vacio el apellido")
    private String apellido;

    @Column(length = 255)
    @Email(message = "El correo necesita una estructura de email")
    @Length(max = 255,message = "El correo paso el limite de caracteres")
    @NotEmpty(message = "No puede estar vacio el correo")
    private String correo;

    @Column(length = 255,nullable = true)
    @Length(max = 255,message = "La dirreccion paso el limite de caracteres")
    @NotEmpty(message = "No puede estar vacio el correo")
    private String direccion;

    @Column(length = 10,nullable = true)
    @Length(min = 0,max = 10,message = "El telefono celular paso el limite de caracteres de 10 o 0")
    private String telefono_cel;

    @Column(length = 9,nullable = true)
    @Length(min = 0,max = 10,message = "El telefono fijo paso el limite de caracteres de 10 p 0")
    private String telefono_fijo;

    @Column(nullable = false,unique=true)
    @Length(min=0,max=10,message = "La dni no puede ser negativa")
    private String dni;

}
