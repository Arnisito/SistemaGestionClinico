package com.example.sistema.v01.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prescripcion")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class prescripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prescripcion")
    private Long id;

    @OneToOne(
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL
    )    
    @JoinColumn(
        name = "id_medicamento",
        referencedColumnName = "id_medicamento"    
    )
    private medicamento medicamento; // medicamento (asosiacion one-to-One)
    @Column(name = "dosis",nullable = false,length = 1000)
    private Float dosis; // cantidad (500mg)
    @Column(name = "frecuencia",nullable = false,length = 100)
    private Float frecuencia; // cada cuanto se debe tomar al dia
    @Column(name = "duracion",nullable = false,length = 100)
    private Long duracion; // cuantos dias se van a tomar
    @ManyToOne(
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "id_receta",
        referencedColumnName = "id_receta"
    )
    private recetasMedica receta; // receta medica (asosiacion many-to-one)
}
