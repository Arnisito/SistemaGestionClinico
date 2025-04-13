package com.example.sistema.v01.model;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.sistema.v01.model.enums.roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class usuario implements UserDetails { //Esta clase esta empleada nomas para el medico (Con esta trabajar para hacer la seguridad mano)

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

    @Column(name = "rol",nullable = false)
    @NotNull(message = "El rol no puede ser nulo")
    @Enumerated(EnumType.STRING)
    private roles roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(roles.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
