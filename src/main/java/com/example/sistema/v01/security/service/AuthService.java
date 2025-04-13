package com.example.sistema.v01.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sistema.v01.model.doctor;
import com.example.sistema.v01.model.usuario;
import com.example.sistema.v01.model.enums.roles;
import com.example.sistema.v01.repository.doctorRepository;
import com.example.sistema.v01.repository.usuarioRepository;
import com.example.sistema.v01.security.model.authRespuesta;
import com.example.sistema.v01.security.model.login;
import com.example.sistema.v01.security.model.registroDeMedico;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    @Autowired
    private usuarioRepository repositoryUsuario;

    @Autowired
    private doctorRepository repositoryDoctor;


    @Autowired
    private jwtService service;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public authRespuesta Login(login login){

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

        UserDetails user = repositoryUsuario.findByUsername(login.getUsername()).orElseThrow();
        String token = service.GenerarToken(user);

        return authRespuesta
            .builder()
            .token(token)  
        .build();
    }

    public authRespuesta RegistroDoctor(registroDeMedico registro){

        usuario usuarioDoctor = usuario.builder()
        .username(registro.getUsername())
        .password(passwordEncoder.encode(registro.getPassword()))
        .roles(roles.DOCTOR)
        .build();
        
        usuarioDoctor = repositoryUsuario.save(usuarioDoctor);

        doctor doc = doctor.builder()
        .nombres(registro.getNombres())
        .apellido(registro.getApellido())
        .area_medica(registro.getArea_medica())
        .correo(registro.getCorreo())
        .direccion(registro.getDireccion())
        .telefono_cel(registro.getTelefono_cel())
        .telefono_fijo(registro.getTelefono_fijo())
        .dni(registro.getDni())
        .cmp(registro.getCmp())
        .usuario(usuarioDoctor)
        .build();

        repositoryDoctor.save(doc);

        return authRespuesta.builder()
            .token("Doctor Registrado en la BD (No hacer caso a esta respuesta de token)")
        .build();

    }

    //pronto.....
    public authRespuesta RegistroAdministrador(){
        return null;
    }

    //pronto....
    public authRespuesta RegistroEnfermero(){
        return null;
    }
}
