package com.example.sistema.v01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.sistema.v01.security.jwt.jwtFiltradorDeAutenticacion;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfiguracionSeguridad {
    
    @Autowired
    private final jwtFiltradorDeAutenticacion filtro;
    
    private final AuthenticationProvider provider;

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests( authorize -> authorize
            .requestMatchers("/auth/**").permitAll()
            .anyRequest().authenticated()
        ).sessionManagement(manger -> manger
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(provider)
            .addFilterBefore(filtro, UsernamePasswordAuthenticationFilter.class)
        .build();
    }

}
