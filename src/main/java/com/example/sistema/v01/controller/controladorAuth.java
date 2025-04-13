package com.example.sistema.v01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistema.v01.security.model.authRespuesta;
import com.example.sistema.v01.security.model.login;
import com.example.sistema.v01.security.model.registroDeMedico;
import com.example.sistema.v01.security.service.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class controladorAuth {
    
    @Autowired
    private final AuthService service;

    @PostMapping("/login")
    public ResponseEntity<authRespuesta> Login(@RequestBody login login) {
        return ResponseEntity.ok(service.Login(login));
    }

    @PostMapping("/registro")
    public ResponseEntity<authRespuesta> Registro(@RequestBody registroDeMedico registro) {
        return ResponseEntity.ok(service.RegistroDoctor(registro));
    }
    
}
