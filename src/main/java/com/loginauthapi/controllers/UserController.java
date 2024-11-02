package com.loginauthapi.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginauthapi.domain.user.User;
import com.loginauthapi.repositories.UserRepository;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping( "/user" )
public class UserController
{
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping
    public ResponseEntity<String> getUser()
    {
        return ResponseEntity.ok( "Success" );
    }
    
    @GetMapping( "/{id}" )
    @Counted( value = "user.count.get.by.id", description = "Count of get user by id requests" )
    @Timed( value = "user.timed.get.by.id", longTask = true, description = "Time taken to get user by id request" )
    public ResponseEntity<User> getUserById( @PathVariable Long id ) 
    {
        Optional<User> user = userRepository.findById( id );

        return user.map( ResponseEntity::ok )
                   .orElseGet( () -> ResponseEntity.notFound()
                                                   .build() );
    }
}
