package com.example.sistema.v01.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
public class usuario { //Esta clase esta empleada nomas para el medico
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "username",nullable = false,unique = true)
    private String username;
    @Column(name = "password",nullable = false,unique = true)
    private String password;
}
