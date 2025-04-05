package com.example.sistema.v01.model;

import java.util.UUID;

import com.example.sistema.v01.model.enums.formatoMedicamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "medicamento")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class medicamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_medicamento")
    private UUID id;
    @Column(name = "nombre_medicamento",nullable = false,length = 200)
    private String nombre; //nombre comercial o generico
    @Column(name = "principo_activo",nullable = false,length = 200)
    private String principio_activo; // sustancia principal del medicamento
    @Column(name = "tipo_formato",nullable = false,length = 200)
    @NotNull(message = "el formato del medicamento no puede estar vacio")
    private formatoMedicamento tipo_formato; // forma farmaceutica(tableta,jarabe,etc)
    @Column(name = "efectos_secundarios",nullable = true,length = 2000)
    private String efectos_secundarios; //efectos secundarios de este medicamento
}
