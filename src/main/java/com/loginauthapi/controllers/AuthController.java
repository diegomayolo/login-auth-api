package com.loginauthapi.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginauthapi.domain.user.User;
import com.loginauthapi.dto.LoginRequestDTO;
import com.loginauthapi.dto.RegisterRequestDTO;
import com.loginauthapi.dto.ResponseDTO;
import com.loginauthapi.infra.security.TokenService;
import com.loginauthapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping( "/auth" )
@RequiredArgsConstructor
public class AuthController
{
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    
    @PostMapping( "/login" )
    public ResponseEntity login( @RequestBody LoginRequestDTO body )
    {
        User user = repository.findByEmail( body.email() ).orElseThrow( () -> new RuntimeException( "User not found" ) );
        
        if ( passwordEncoder.matches( body.password(), user.getPassword() ) )
        {
            String token = tokenService.generateToken( user );
            
            return ResponseEntity.ok( new ResponseDTO( user.getName(), token ) );
        }
        
        return ResponseEntity.badRequest().build();
    }
    
    @PostMapping( "/register" )
    public ResponseEntity register( @RequestBody RegisterRequestDTO body )
    {
        Optional<User> user = repository.findByEmail( body.email() );
        
        if ( user.isEmpty() )
        {
            User newUser = new User();
            newUser.setName( body.name() );
            newUser.setEmail( body.email() );
            newUser.setPassword( passwordEncoder.encode( body.password() ) );
            
            repository.save( newUser );

            String token = tokenService.generateToken( newUser );

            return ResponseEntity.ok( new ResponseDTO( newUser.getName(), token ) );
        }
        
        return ResponseEntity.badRequest().build();
    }
}
