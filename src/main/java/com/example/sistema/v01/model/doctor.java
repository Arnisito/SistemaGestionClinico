package com.example.sistema.v01.model;

import org.hibernate.validator.constraints.Length;

import com.example.sistema.v01.model.enums.areaMedica;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="doctor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class doctor extends persona{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doctor")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "area_medica",nullable = false)
    @NotEmpty(message = "No puede esta vacio el area medica del doctor")
    private areaMedica area_medica;
    
    @Column(name = "cmp_doc",length = 10,nullable = false,unique = true)
    @Length(min = 0,max = 10,message = "El cmp del doctor no puede superar los 10 caracteres o tener caracteres negativos")
    @NotEmpty(message = "No puede esta vacio el cmp del doctor")
    private String cmp;

    @OneToOne(
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "id_usuario",
        referencedColumnName = "id_usuario"
    )
    private usuario usuario;
}
