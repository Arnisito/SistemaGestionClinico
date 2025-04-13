package com.example.sistema.v01.security.service;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.SIG;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class jwtService {
    
    private static final String SECRET_KEY = "yTBtTez2C4cO3Yfp0mLjK9g2s6dL0sF+P6eOdq8XEmg=";

    public String GenerarTokenDetalles(Map<String, Object> extraClaims, UserDetails userDetails) {
        Date FechaActual = new Date();
        Date FechaDeExpiracion = new Date(FechaActual.getTime() + 1000 * 60 * 24); 

        return Jwts.builder()
            .claims(extraClaims)
            .subject(userDetails.getUsername())
            .issuedAt(FechaActual)
            .expiration(FechaDeExpiracion)
            .signWith(ObtenerLLave(), SIG.HS256) 
        .compact();
    }

    public String GenerarToken(UserDetails userDetails) {
        return GenerarTokenDetalles(Map.of(), userDetails);
    }
    
    private SecretKey ObtenerLLave() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes); 
    }

    public Claims getAllClaims(String token) {
        return Jwts.parser()
            .verifyWith(ObtenerLLave())
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }

    public <T> T getClaim(String token,Function<Claims,T>claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String getUsernameFromToken(String token){
        return getClaim(token, Claims::getSubject);
    }

    private Date getExpiration(String token){
        return getClaim(token, Claims::getExpiration);
    }

    private Boolean isTokenExpiration(String token){
        return getExpiration(token).before(new Date());
    }

    public boolean isTokenValid(String token,UserDetails userDetails){
        final String Username = getUsernameFromToken(token);
        return (Username.equals(userDetails.getUsername()) && !isTokenExpiration(token));
    }

}
