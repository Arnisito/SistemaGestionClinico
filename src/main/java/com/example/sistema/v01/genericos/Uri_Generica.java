package com.example.sistema.v01.genericos;

import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class Uri_Generica {

    // si lo van usar recueden que en id debe poner el id del objeto como ejemplo:paciente.getId()
    public static URI MiUri(String url,Object id){
        return ServletUriComponentsBuilder
            .fromCurrentContextPath()
            .path(url)
            .buildAndExpand(id)
        .toUri();
    }

}
