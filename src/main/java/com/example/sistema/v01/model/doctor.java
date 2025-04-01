package com.example.sistema.v01.model;

import com.example.sistema.v01.model.enums.areaMedica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class doctor extends persona{
    private Long id;
    private areaMedica areaMedica;
    private Long cmp;
}
