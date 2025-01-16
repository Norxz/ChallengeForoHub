package com.desafio.foro.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.desafio.foro.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    
    
    @Value ("${api.security.secret}")
    private String apiSecret;
    
    public String getToken (User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                           .withIssuer("foro hub")
                           .withSubject(user.getLogin ())
                           .withClaim ("id", user.getId ())
                           .withExpiresAt (generarFechaExpiracion())
                           .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }
    
    public String getSubject(String token) {
        if (token == null) throw new RuntimeException("El token no puede ser nulo");
        
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret); // Usa el secreto configurado
            DecodedJWT verifier = JWT.require(algorithm)
                                          .withIssuer("foro hub")
                                          .build()
                                          .verify(token);
            
            String subject = verifier.getSubject();
            if (subject == null) {
                throw new RuntimeException("El token no tiene un subject válido");
            }
            
            return subject;
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Error al verificar el token: " + exception.getMessage());
        }
    }
    
    private static Instant generarFechaExpiracion (){
        return LocalDateTime.now ().plusHours (2).toInstant (ZoneOffset.of("-05:00"));
    }
    
    
}
