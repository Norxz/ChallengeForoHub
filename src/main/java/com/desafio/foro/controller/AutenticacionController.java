package com.desafio.foro.controller;

import com.desafio.foro.domain.user.DatosAutenticacionUser;
import com.desafio.foro.domain.user.User;
import com.desafio.foro.security.DatosJWTToken;
import com.desafio.foro.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class AutenticacionController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private TokenService tokenService;
    
    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUser DatosAutenticacionUser) {
        Authentication authToken = new UsernamePasswordAuthenticationToken (DatosAutenticacionUser.email (), DatosAutenticacionUser.password ());
        System.out.println (authToken);
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        System.out.println (usuarioAutenticado);
        var JWTtoken = tokenService.getToken ((User) usuarioAutenticado.getPrincipal ());
        System.out.println (JWTtoken);
        return ResponseEntity.ok(new DatosJWTToken (JWTtoken) );
    }
    
}
