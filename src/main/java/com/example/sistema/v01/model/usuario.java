package com.example.sistema.v01.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="usuario")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class usuario { //Esta clase esta empleada nomas para el medico (Con esta trabajar para hacer la seguridad mano)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private UUID id;

    @Column(name = "username",nullable = false,unique = true,length = 100)
    @NotEmpty(message = "No puede estar vacio el campo username del doctor")
    private String username;
    @Column(name = "password",nullable = false,unique = true,length = 100)
    @NotEmpty(message = "No puede estar vacio el campo password del doctor")
    private String password;
}
